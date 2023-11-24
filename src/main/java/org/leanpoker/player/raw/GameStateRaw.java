package org.leanpoker.player.raw;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class GameStateRaw {

    @JsonProperty("tournament_id")
    private String tournamentId;

    @JsonProperty("game_id")
    private String gameId;

    private int round;

    private List<PlayerRaw> players;

    @JsonProperty("small_blind")
    private int smallBlind;

    @JsonProperty("big_blind")
    private int bigBlind;

    private int orbits;

    private int dealer;

    @JsonProperty("community_cards")
    private List<CardRaw> communityCards;

    @JsonProperty("current_buy_in")
    private int currentBuyIn;

    private int pot;

    @JsonProperty("in_action")
    private int inAction;

    @JsonProperty("minimum_raise")
    private int minimumRaise;

    @JsonProperty("bet_index")
    private int betIndex;

    public String getTournamentId() {
        return tournamentId;
    }

    public String getGameId() {
        return gameId;
    }

    public GameStateRaw setGameId(String gameId) {
        this.gameId = gameId;
        return this;
    }

    public int getRound() {
        return round;
    }

    public GameStateRaw setRound(int round) {
        this.round = round;
        return this;
    }

    public List<PlayerRaw> getPlayers() {
        return players;
    }

    public GameStateRaw setPlayers(List<PlayerRaw> players) {
        this.players = players;
        return this;
    }

    public int getSmallBlind() {
        return smallBlind;
    }

    public GameStateRaw setSmallBlind(int smallBlind) {
        this.smallBlind = smallBlind;
        return this;
    }

    public int getBigBlind() {
        return bigBlind;
    }

    public GameStateRaw setBigBlind(int bigBlind) {
        this.bigBlind = bigBlind;
        return this;
    }

    public int getOrbits() {
        return orbits;
    }

    public GameStateRaw setOrbits(int orbits) {
        this.orbits = orbits;
        return this;
    }

    public int getDealer() {
        return dealer;
    }

    public GameStateRaw setDealer(int dealer) {
        this.dealer = dealer;
        return this;
    }

    public List<CardRaw> getCommunityCards() {
        return communityCards;
    }

    public GameStateRaw setCommunityCards(List<CardRaw> communityCards) {
        this.communityCards = communityCards;
        return this;
    }

    public int getCurrentBuyIn() {
        return currentBuyIn;
    }

    public GameStateRaw setCurrentBuyIn(int currentBuyIn) {
        this.currentBuyIn = currentBuyIn;
        return this;
    }

    public int getPot() {
        return pot;
    }

    public GameStateRaw setPot(int pot) {
        this.pot = pot;
        return this;
    }

    public int getInAction() {
        return inAction;
    }

    public GameStateRaw setInAction(int inAction) {
        this.inAction = inAction;
        return this;
    }

    public int getMinimumRaise() {
        return minimumRaise;
    }

    public GameStateRaw setMinimumRaise(int minimumRaise) {
        this.minimumRaise = minimumRaise;
        return this;
    }

    public int getBetIndex() {
        return betIndex;
    }

    public GameStateRaw setBetIndex(int betIndex) {
        this.betIndex = betIndex;
        return this;
    }

    public GameStateRaw setTournamentId(String tournamentId) {
        this.tournamentId = tournamentId;
        return this;
    }

    @Override
    public String toString() {
        return "GameStateRaw{" +
                "tournamentId='" + tournamentId + '\'' +
                ", gameId='" + gameId + '\'' +
                ", round=" + round +
                ", players=" + players +
                ", smallBlind=" + smallBlind +
                ", bigBlind=" + bigBlind +
                ", orbits=" + orbits +
                ", dealer=" + dealer +
                ", communityCards=" + communityCards +
                ", currentBuyIn=" + currentBuyIn +
                ", pot=" + pot +
                ", inAction=" + inAction +
                ", minimumRaise=" + minimumRaise +
                ", betIndex=" + betIndex +
                '}';
    }

    public void getUs() {

    }
}

