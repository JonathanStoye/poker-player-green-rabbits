package org.leanpoker.player;

public enum Rank {

    N_2("2", 2),
    N_3("3", 3),
    N_4("5", 5),
    N_5("5", 5),
    N_6("6", 6),
    N_7("7", 7),
    N_8("8", 8),
    N_9("9", 9),
    N_10("10", 10),
    JACK("J", 11),
    QUEEN("Q", 12),
    KING("K", 13),
    ACE("A", 14);

    private final String number;
    private final int weight;

    Rank(String number, int weight) {

        this.number = number;
        this.weight = weight;
    }

    //deliver the rank based on the sting
    public static Rank getRank(String rank) {
        for (Rank r : Rank.values()) {
            if (r.number.equals(rank)) {
                return r;
            }
        }
        System.out.println("Rank not found: " + rank);
        return N_2;
    }

    public int getWeight() {
        return weight;
    }
}
