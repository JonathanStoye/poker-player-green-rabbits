package org.leanpoker.player;

import com.fasterxml.jackson.databind.JsonNode;

import java.util.ArrayList;
import java.util.List;

public class Player {
    static final String VERSION = "5 - our cards";

    private List<Card> mycards = new ArrayList<>();

    @Override
    public String toString() {
        return "Player{" +
                "mycards=" + mycards +
                '}';
    }


    public static int betRequest(JsonNode request) {

        Player we = new Player();

        System.out.println("request");
        System.out.println(request.toPrettyString());

        request.get("players").forEach(player -> {
            System.out.println("player");
            System.out.println(player.toPrettyString());
        });

        JsonNode players = request.get("players");

        players.forEach(player -> {
            if ("Green Rabbits".equals(player.get("name").asText())) {
                player.get("hole_cards").forEach(card -> {
                    we.mycards.add(new Card(card.get("rank").asText(), card.get("suit").asText()));
                });
            }

            System.out.println("found us: " + we);
        });

        return 1000;
    }

    public static void showdown(JsonNode game) {
        System.out.println("game at showdown");
        System.out.println(game.toPrettyString());
    }
}
