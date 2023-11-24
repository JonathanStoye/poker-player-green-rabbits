package org.leanpoker.player.raw;

public class CardRaw {

    private String rank;
    private String suit;

    public String getRank() {
        return rank;
    }

    public CardRaw setRank(String rank) {
        this.rank = rank;
        return this;
    }

    public String getSuit() {
        return suit;
    }

    public CardRaw setSuit(String suit) {
        this.suit = suit;
        return this;
    }

    @Override
    public String toString() {
        return "CardRaw{" +
                "rank='" + rank + '\'' +
                ", suit='" + suit + '\'' +
                '}';
    }
}
