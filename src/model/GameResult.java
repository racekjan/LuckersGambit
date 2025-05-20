package model;

import core.Game;

public class GameResult {
    private Game game;
    private int winnings, bet;
    private boolean status;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public int getWinnings() {
        return winnings;
    }

    public void setWinnings(int winnings) {
        this.winnings = winnings;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getBet() {
        return bet;
    }

    public GameResult(Game game, int winnings, int bet, boolean status) {
        this.game = game;
        this.winnings = winnings;
        this.bet = bet;
        this.status = status;
    }

    @Override
    public String toString() {
        return status ? "Game: " + game.getGameName()
                + "\n Vsazeno: " + getBet()
                + "\n Vyhrana castka: " + getWinnings()
                :
                "Game: " + game.getGameName()
                + "\n Vsazeno: " + getBet()
                + "\n Prohrano";
    }
}
