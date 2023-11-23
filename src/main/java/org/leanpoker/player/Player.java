package org.leanpoker.player;

import com.fasterxml.jackson.databind.JsonNode;

public class Player {

    static final String VERSION = "3 - pretty";

    public static int betRequest(JsonNode request) {
        System.out.println("request");
        System.out.println(request.toPrettyString());


        return 1000;
    }

    public static void showdown(JsonNode game) {
        System.out.println("game at showdown");
        System.out.println(game.toPrettyString());
    }
}
