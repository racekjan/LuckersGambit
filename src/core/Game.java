package core;

import model.GameResult;
import model.Player;
import ui.InputHandler;

import java.io.Serial;
import java.io.Serializable;

public abstract class Game implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;
    String gameName;
    Player player;
    int minBet, inputBet;

    public String getGameName() {
        return gameName;
    }

    public Player getPlayer() {
        return player;
    }

    public int getMinBet() {
        return minBet;
    }

    public Game(String gameName, int minBet) {
        this.gameName = gameName;
        this.minBet = minBet;
    }

    public int getInputBet() {
        return inputBet;
    }

    public boolean loadPlayer(Player player){
        this.player = player;
        if (player.getBalance() >= minBet){
            inputBet = InputHandler.readInt("Zadej, kolik chces vsadit", minBet, player.getBalance());
            return true;
        }
        System.out.println("Nemate na ucte minimalni castku pro hrani teto hry (" + getMinBet() + ")");
        return false;
    }

    public abstract GameResult startGame();
}
