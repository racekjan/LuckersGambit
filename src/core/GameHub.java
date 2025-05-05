package core;

import model.Player;

public class GameHub {
    Player player;

    public Player getPlayer() {
        return player;
    }

    public GameHub(Player player) {
        this.player = player;
    }

    public void hubLoop(){
        System.out.println("Dostali jsme se do hubu");
    }

}
