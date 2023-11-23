package org.leanpoker.player;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.leanpoker.player.Rank.*;
import static org.leanpoker.player.Suit.*;

class AllCardsTest {

    @Test
    void should() {
        AllCards allCards = new AllCards();

        allCards.addMyCard(new Card(N_10, HEARTS));
        allCards.addMyCard(new Card(N_9, HEARTS));
        allCards.addCommunityCard(new Card(N_10, HEARTS));
        allCards.addCommunityCard(new Card(N_10, HEARTS));

        assertEquals(true, allCards.hasEqualCardsWithMinWeightAndMinNumber(9, 2));
        assertEquals(true, allCards.hasEqualCardsWithMinWeightAndMinNumber(9, 3));
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