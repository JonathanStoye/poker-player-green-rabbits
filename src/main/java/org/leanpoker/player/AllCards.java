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

    private boolean hasCardRank(Rank rank) {
        return allCards.stream().anyMatch(card -> card.getRank().equals(rank));
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



        return rankMap.entrySet().stream()
                .anyMatch(entry -> entry.getValue() >= number
                        &&
                        // mycars enthält eine karte mit dem gleichen rank
                        mycards.stream().anyMatch(card -> card.getRank().equals(entry.getKey()))
                );
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
