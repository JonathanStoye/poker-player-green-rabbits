package org.leanpoker.player;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.leanpoker.player.raw.GameStateRaw;

import static org.leanpoker.player.Rank.N_10;

public class BetService {
    private final int bet;
    static final String VERSION = "v21 - strat";

    public BetService(int bet) {
        this.bet = bet;
    }


    public static int betRequest(JsonNode request) {
        GameStateRaw gameStateRaw = getGameStateRaw(request);
        GameState gameState = new GameState(gameStateRaw);

        BetService we = null;
        AllCards allCards = new AllCards();

        System.out.println("request");
        System.out.println(request.toPrettyString());

        request.get("players").forEach(player -> {
            System.out.println("player");
            System.out.println(player.toPrettyString());
        });

        JsonNode players = request.get("players");

        gameState.getUs().getHoleCards().forEach(card -> {
            allCards.addMyCard(
                    new Card(
                            Rank.getRank(card.getRank()),
                            Suit.getSuit(card.getSuit())));
        });


        // iterate the players and find our player
        for (JsonNode player : players) {
            if ("Green Rabbits".equals(player.get("name").asText())) {
                we = new BetService(player.get("bet").asInt());

                player.get("hole_cards").forEach(card -> {
                    allCards.addMyCard(
                            new Card(
                                    Rank.getRank(card.get("rank").asText()),
                                    Suit.getSuit(card.get("suit").asText())));
                });
            }
        }

        gameStateRaw.getCommunityCards().forEach(cardRaw -> {
            allCards.addCommunityCard(
                    new Card(cardRaw)
            );
        });


        if (allCards.hasEqualCardsWithMinWeightAndMinNumber(1, 4)) {
            System.out.println("allCards.hasEqualCardsWithMinWeightAndMinNumber(1, 4)");
            return 1000 + gameStateRaw.getCurrentBuyIn();
        }

        if (allCards.hasEqualCardsWithMinWeightAndMinNumber(1, 3)) {
            System.out.println("allCards.hasEqualCardsWithMinWeightAndMinNumber(1, 3)");
            return 500 + gameStateRaw.getCurrentBuyIn();
        }


        if (allCards.hasEqualCardsWithMinWeightAndMinNumber(10, 2) ) {
            System.out.println("allCards.hasEqualCardsWithMinWeightAndMinNumber(10, 2)");
            return gameStateRaw.getCurrentBuyIn() - we.bet + gameStateRaw.getMinimumRaise() + gameStateRaw.getMinimumRaise();
        }

        if (allCards.isWithoutCommunityCards() && allCards.hasMinRank(N_10)) {
            System.out.println("allCards.isWithoutCommunityCards() && allCards.hasMinRank(N_10)");
            return gameStateRaw.getCurrentBuyIn() - we.bet + gameStateRaw.getMinimumRaise();
        }

        if (gameStateRaw.getCurrentBuyIn() < 10 ) {
            System.out.println("gameStateRaw.getCurrentBuyIn() < 10");
            return gameStateRaw.getCurrentBuyIn() - we.bet; // calling
        }

        return 0;
    }

    private static GameStateRaw getGameStateRaw(JsonNode request) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            GameStateRaw gameStateRaw = objectMapper.treeToValue(request, GameStateRaw.class);
            System.out.println(gameStateRaw.toString());
            return gameStateRaw;
        } catch (JsonProcessingException e) {
            System.out.println("error parsing json");
            System.out.println(request.toPrettyString());
        }
        return null;
    }

    public static void showdown(JsonNode game) {
        System.out.println("game at showdown");
        System.out.println(game.toPrettyString());
    }
}
