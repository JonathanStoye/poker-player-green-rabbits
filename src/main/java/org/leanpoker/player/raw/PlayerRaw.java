package org.leanpoker.player.raw;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PlayerRaw {

    private String name;
    private int stack;
    private String status;
    private int bet;
    @JsonProperty("time_used")
    private int timeUsed;
    private String version;
    private int id;
    @JsonProperty("hole_cards")
    private List<CardRaw> holeCards;

    public String getName() {
        return name;
    }

    public PlayerRaw setName(String name) {
        this.name = name;
        return this;
    }

    public int getStack() {
        return stack;
    }

    public PlayerRaw setStack(int stack) {
        this.stack = stack;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public PlayerRaw setStatus(String status) {
        this.status = status;
        return this;
    }

    public int getBet() {
        return bet;
    }

    public PlayerRaw setBet(int bet) {
        this.bet = bet;
        return this;
    }

    public int getTimeUsed() {
        return timeUsed;
    }

    public PlayerRaw setTimeUsed(int timeUsed) {
        this.timeUsed = timeUsed;
        return this;
    }

    public String getVersion() {
        return version;
    }

    public PlayerRaw setVersion(String version) {
        this.version = version;
        return this;
    }

    public int getId() {
        return id;
    }

    public PlayerRaw setId(int id) {
        this.id = id;
        return this;
    }

    public List<CardRaw> getHoleCards() {
        return holeCards;
    }

    public PlayerRaw setHoleCards(List<CardRaw> holeCards) {
        this.holeCards = holeCards;
        return this;
    }

    @Override
    public String toString() {
        return "PlayerRaw{" +
                "name='" + name + '\'' +
                ", stack=" + stack +
                ", status='" + status + '\'' +
                ", bet=" + bet +
                ", timeUsed=" + timeUsed +
                ", version='" + version + '\'' +
                ", id=" + id +
                ", holeCards=" + holeCards +
                '}';
    }
}
