package org.leanpoker.player;

public class Card {

    private Rank rank;
    private String suit;

    public Card(Rank rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "rank='" + rank + '\'' +
                ", suit='" + suit + '\'' +
                '}';
    }
}
