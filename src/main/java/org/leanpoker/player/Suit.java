package org.leanpoker.player;

public enum Suit {

    CLUBS("clubs"),
    HEARTS("hearts"),
    DIAMONDS("diamonds"),
    SPADES("spades");

    private final String name;

    Suit(String name) {
        this.name = name;
    }

    //deliver the suit based on the sting
    public static Suit getSuit(String suit) {
        for (Suit s : Suit.values()) {
            if (s.name.equals(suit)) {
                return s;
            }
        }
        System.out.println("Suit not found: " + suit);
        return CLUBS;
    }
}
