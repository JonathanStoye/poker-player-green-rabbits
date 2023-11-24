package org.leanpoker.player;

import org.leanpoker.player.raw.GameStateRaw;

public class GameState {

    private static final int MAX_RAISE = 1000;
    private static final String ownName = "Green Rabbits";

    private final GameStateRaw gameStateRaw;

    public GameState(GameStateRaw gameStateRaw) {
        this.gameStateRaw = gameStateRaw;
    }
}
