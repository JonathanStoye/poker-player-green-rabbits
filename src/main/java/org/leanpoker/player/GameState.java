package org.leanpoker.player;

import org.leanpoker.player.raw.GameStateRaw;

public class GameState {

    private static final int MAX_RAISE = 1000;
    private static final String ownName = "Green Rabbits";

    private final Player ownPlayer;

    private final GameStateRaw gameStateRaw;

    public GameState(GameStateRaw gameStateRaw) {
        this.gameStateRaw = gameStateRaw;
        this.ownPlayer = new Player(gameStateRaw.getPlayers().stream().filter(playerRaw -> ownName.equals(playerRaw.getName())).findFirst().get());
    }
}
