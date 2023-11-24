package org.leanpoker.player;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.leanpoker.player.raw.GameStateRaw;

public class BetService {
    private final int bet;
    static final String VERSION = "v19 - own";

    public BetService(int bet) {
        this.bet = bet;
    }


    public static int betRequest(JsonNode request) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();
            GameStateRaw gameStateRaw = objectMapper.treeToValue(request, GameStateRaw.class);
            System.out.println("gameStateRaw erfolgreich gelesen.");
            System.out.println(gameStateRaw.toString());

        } catch (Throwable t) {
            System.out.println("Error: " + t.getMessage());
        }



        BetService we = null;
        AllCards allCards = new AllCards();

        System.out.println("request");
        System.out.println(request.toPrettyString());

        request.get("players").forEach(player -> {
            System.out.println("player");
            System.out.println(player.toPrettyString());
        });

        JsonNode players = request.get("players");

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

        request.get("community_cards").forEach(card -> {
            allCards.addCommunityCard(
                    new Card(
                            Rank.getRank(card.get("rank").asText()),
                            Suit.getSuit(card.get("suit").asText()))
            );
        });

        int mimimumRaise = request.get("minimum_raise").asInt();
        int currentBuyIn = request.get("current_buy_in").asInt();

        if (allCards.hasEqualCardsWithMinWeightAndMinNumber(1, 4)) {
            return 1000 + currentBuyIn;
        }

        if (allCards.hasEqualCardsWithMinWeightAndMinNumber(1, 3)) {
            return 500 + currentBuyIn;
        }

        if (allCards.hasEqualCardsWithMinWeightAndMinNumber(10, 2)) {
            return currentBuyIn - we.bet + mimimumRaise;
        }

        if (currentBuyIn < 10) {
            return currentBuyIn - we.bet; // calling
        }

        return 0;
    }

    public static void showdown(JsonNode game) {
        System.out.println("game at showdown");
        System.out.println(game.toPrettyString());
    }
}
