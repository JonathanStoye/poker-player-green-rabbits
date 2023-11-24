package org.leanpoker.player;

import org.leanpoker.player.raw.CardRaw;

import java.util.Objects;

public class Card {

    private Rank rank;
    private Suit suit;

    public Card(CardRaw cardRaw) {
        this.rank = Rank.getRank(cardRaw.getRank());
        this.suit = Suit.getSuit(cardRaw.getSuit());
    }

    public Card(Rank rank, Suit suit) {
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

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return rank == card.rank && suit == card.suit;
    }

    @Override
    public int hashCode() {
        return Objects.hash(rank, suit);
    }
}
