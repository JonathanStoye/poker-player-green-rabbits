package org.leanpoker.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.leanpoker.player.Rank.*;
import static org.leanpoker.player.Suit.*;

class AllCardsTest {

    @Test
    void should2() {
        AllCards allCards = new AllCards();

        allCards.addMyCard(new Card(N_10, HEARTS));
        allCards.addMyCard(new Card(N_9, HEARTS));
        allCards.addCommunityCard(new Card(N_10, HEARTS));
        allCards.addCommunityCard(new Card(N_10, HEARTS));

        assertEquals(true, allCards.hasEqualCardsWithMinWeightAndMinNumber(9, 2));
    }
    void should3() {
        AllCards allCards = new AllCards();

        allCards.addMyCard(new Card(N_10, HEARTS));
        allCards.addMyCard(new Card(N_9, HEARTS));
        allCards.addCommunityCard(new Card(N_10, DIAMONDS));
        allCards.addCommunityCard(new Card(N_10, CLUBS));

        assertEquals(true, allCards.hasEqualCardsWithMinWeightAndMinNumber(9, 3));
    }
    void should4() {
        AllCards allCards = new AllCards();

        allCards.addMyCard(new Card(N_10, HEARTS));
        allCards.addMyCard(new Card(N_9, HEARTS));
        allCards.addCommunityCard(new Card(N_10, DIAMONDS));
        allCards.addCommunityCard(new Card(N_10, CLUBS));

        assertEquals(false, allCards.hasEqualCardsWithMinWeightAndMinNumber(9, 4));
    }

    @Test
    void shouldUC1() {
        AllCards allCards = new AllCards();
        allCards.addMyCard(new Card(QUEEN, HEARTS));
        allCards.addMyCard(new Card(QUEEN, DIAMONDS));

        assertEquals(true, allCards.hasEqualCardsWithMinWeightAndMinNumber(10, 2));

    }
    @Test
    void b1() {
        AllCards allCards = new AllCards();
        allCards.addMyCard(new Card(N_2, CLUBS));
        allCards.addMyCard(new Card(N_3, DIAMONDS));

        assertEquals(false, allCards.hasEqualCardsWithMinWeightAndMinNumber(1, 4));


    }

    @Test
    void shouldBeFold() {
        AllCards allCards = new AllCards();
        allCards.addCommunityCard(new Card(QUEEN, HEARTS));
        allCards.addCommunityCard(new Card(QUEEN, DIAMONDS));
        allCards.addCommunityCard(new Card(QUEEN, SPADES));

        assertEquals(true, allCards.isFold());
    }

    @Test
    void shouldBeWithoutCommunityCards() {
        AllCards allCards = new AllCards();

        assertEquals(true, allCards.isWithoutCommunityCards());
    }
}