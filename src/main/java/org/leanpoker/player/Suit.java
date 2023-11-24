package org.leanpoker.player;

import io.micronaut.context.BeanProvider;

import java.util.List;

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

    public static List<Suit> getSuits() {
        return List.of(CLUBS, HEARTS, DIAMONDS, SPADES);
    }
}
