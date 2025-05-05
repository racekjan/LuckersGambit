package core;

import model.Player;

public abstract class Game {
    String gameName;
    Player player;
    int minBet;

    public Game(String gameName, int minBet) {
        this.gameName = gameName;
        this.minBet = minBet;
    }

    public void loadPlayer(Player player){
        this.player = player;
    }

    public abstract void startGame();
}
