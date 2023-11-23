package org.leanpoker.player;

import com.fasterxml.jackson.databind.JsonNode;

public class Player {

    static final String VERSION = "2 - with sysout";

    public static int betRequest(JsonNode request) {
        System.out.println("request");
        System.out.println(request);
        return 1000;
    }

    public static void showdown(JsonNode game) {
        System.out.println("game at showdown");
        System.out.println(game);
    }
}
