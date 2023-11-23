package org.leanpoker.player;

import java.util.ArrayList;
import java.util.List;

public class AllCards {
    private List<Card> mycards = new ArrayList<>();
    private List<Card> communityCards = new ArrayList<>();

    private List<Card> allCards = new ArrayList<>();

    public void addCommunityCard(Card card) {
        communityCards.add(card);
        allCards.add(card);
    }

    public void addMyCard(Card card) {
        mycards.add(card);
        allCards.add(card);
    }


    @Override
    public String toString() {
        return "AllCards{" +
                "mycards=" + mycards +
                ", communityCards=" + communityCards +
                '}';
    }

    public boolean hasPairInAllCards() {
        for (int i = 0; i < allCards.size(); i++) {
            for (int j = i + 1; j < allCards.size(); j++) {
                if (allCards.get(i).getRank() == allCards.get(j).getRank()) {
                    return true;
                }
            }
        }
        return false;
    }
    public boolean hasPairInAllCardsWithMinWeight(int weight) {
        for (int i = 0; i < allCards.size(); i++) {
            for (int j = i + 1; j < allCards.size(); j++) {
                if (allCards.get(i).getRank() == allCards.get(j).getRank() && allCards.get(i).getRank().getWeight() >= weight) {
                    return true;
                }
            }
        }
        return false;
    }

    // make a methode from all cards to check there is minimum the given number of cards with same rank and min the given weight
    public boolean hasEqualCardsWithMinWeightAndMinNumber(int weight, int number) {
        int counter = 0;
        for (int i = 0; i < allCards.size(); i++) {
            for (int j = i + 1; j < allCards.size(); j++) {
                if (allCards.get(i).getRank() == allCards.get(j).getRank() && allCards.get(i).getRank().getWeight() >= weight) {
                    counter++;
                }
            }
        }
        if (counter >= number) {
            return true;
        }
        return false;
    }
}
