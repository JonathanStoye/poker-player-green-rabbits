package org.leanpoker.player;

import com.fasterxml.jackson.databind.JsonNode;

public class Player {
    private final int bet;
    static final String VERSION = "v8 equal ranks";

    public Player(int bet) {
        this.bet = bet;
    }


    public static int betRequest(JsonNode request) {
        AllCards allCards = new AllCards();

        System.out.println("request");
        System.out.println(request.toPrettyString());

        request.get("players").forEach(player -> {
            System.out.println("player");
            System.out.println(player.toPrettyString());
        });

        JsonNode players = request.get("players");

        players.forEach(player -> {
            if ("Green Rabbits".equals(player.get("name").asText())) {
                new Player(player.get("bet").asInt());

                player.get("hole_cards").forEach(card -> {
                    allCards.addMyCard(
                            new Card(
                                    Rank.getRank(card.get("rank").asText()),
                                    Suit.getSuit(card.get("suit").asText())));
                });
            }
        });



        request.get("community_cards").forEach(card -> {
            allCards.addCommunityCard(
                    new Card(
                            Rank.getRank(card.get("rank").asText()),
                            Suit.getSuit(card.get("suit").asText()))
            );
        });

        if (allCards.hasEqualCardsWithMinWeightAndMinNumber(1, 4)) {
            return 1000;
        }
        else if (allCards.hasEqualCardsWithMinWeightAndMinNumber(1, 3)) {
            return 500;
        }
        if (allCards.hasEqualCardsWithMinWeightAndMinNumber(10, 2)) {
            return 100;
        } else {
            return 0;
        }
    }

    public static void showdown(JsonNode game) {
        System.out.println("game at showdown");
        System.out.println(game.toPrettyString());
    }
}
