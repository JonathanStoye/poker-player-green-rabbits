package org.leanpoker.player;

import org.leanpoker.player.raw.CardRaw;

import java.util.List;

public class Cards {
    private List<Card> cards;

    public Cards(List<CardRaw> cardsRaw) {
        for (CardRaw cardRaw : cardsRaw) {
            cards.add(new Card(cardRaw));
        }
    }
}
