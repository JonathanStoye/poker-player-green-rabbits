package org.leanpoker.player;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
       Map<Rank, Integer> rankMap = new HashMap<>();

       for (Card card : allCards) {
            if (card.getRank().getWeight() >= weight) {
                if (rankMap.containsKey(card.getRank())) {
                    rankMap.put(card.getRank(), rankMap.get(card.getRank()) + 1);
                } else {
                    rankMap.put(card.getRank(), 1);
                }
            }
        }

        // Überprüfe, ob es mindestens eine Karte in mycards mit dem erforderlichen Gewicht und der erforderlichen Anzahl gibt
        for (Card card : mycards) {
            if (card.getRank().getWeight() >= weight && rankMap.getOrDefault(card.getRank(), 0) >= number && mycards.contains(card)) {
                return true;
            }
        }

        return false;
    }

    public boolean isFold() {
        return communityCards.size() == 3;
    }

    public boolean isTurn() {
        return communityCards.size() == 4;
    }

    public boolean isRiver() {
        return communityCards.size() == 5;
    }

    public boolean isWithoutCommunityCards() {
        return communityCards.size() < 3;
    }
}
