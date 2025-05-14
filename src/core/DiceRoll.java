package core;

import assets.RandomGen;
import model.GameResult;
import ui.InputHandler;

public class DiceRoll extends Game {
    public DiceRoll(String gameName, int minBet) {
        super(gameName, minBet);
    }

    public static void printTrack(int position) {
        final int FIELD_COUNT = 7;
        StringBuilder output = new StringBuilder();

        if (position == 0) {
            output.append("卐 -> "); // pred hracim polem
        }

        for (int i = 1; i <= FIELD_COUNT; i++) {
            if (position == i) {
                output.append("[ 卐 ]");
            } else {
                output.append(String.format("[ %d ]", i));
            }
        }

        if (position > FIELD_COUNT) {
            output.append(" -> 卐"); // jiz za hracim polem
        }

        System.out.println(output);
    }

//    public static void main(String[] args) {
//
//        printTrack(0);
//        printTrack(2);
//        printTrack(3);
//        printTrack(6);
//        printTrack(7);
//        printTrack(8);
//
//    }

    @Override
    public GameResult startGame() {
        System.out.println("Vsazeno " + getInputBet());
        int winnings = getInputBet();
        player.decreaseBalance(getInputBet());
        int position = 0;
        printTrack(position);
        int choice = InputHandler.readChoices("Zacatek hry, chces risknout?", "Ano", "Ne");
        while(choice!=1){
            System.out.println("Kostka");
            position += RandomGen.getRandomInt(1,6);
            printTrack(position);
            if (position>=8){
                break;
            }
            choice = InputHandler.readChoices("Chcete pokracovat?", "Ano", "Ne");
        }
        if (position>=1 && position <=4){
            winnings*=1.1;
        } else if (position<=6) {
            winnings*=1.4;
        } else if (position ==7) {
            winnings*=2;
        } else {
            winnings=0;
        }
        player.increaseBalance(winnings);
        if (winnings==0){
            System.out.println("Prohral jste");
            return new GameResult(this, 0, false);
        }else  {
            System.out.println("Vyhral jste " + winnings);
        }
        System.out.println(player.getBalance());
        return new GameResult(this, winnings, true);
    }
}
