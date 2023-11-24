package org.leanpoker.player;

import org.leanpoker.player.raw.GameStateRaw;

public class GameState {

    private final GameStateRaw gameStateRaw;

    public GameState(GameStateRaw gameStateRaw) {
        this.gameStateRaw = gameStateRaw;
    }
}
