package org.leanpoker.player;

import org.leanpoker.player.raw.PlayerRaw;

public class Player {

    private final PlayerRaw playerRaw;

    private final Cards cards;

    public Player(PlayerRaw playerRaw) {
        this.playerRaw = playerRaw;
        this.cards = new Cards(playerRaw.getHoleCards());
    }

}
