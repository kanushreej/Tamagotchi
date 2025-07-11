package softwaredesign;

import java.util.Random;
import java.util.Scanner;

public abstract class Minigame {
    public static boolean gameRunning = false;

    public static void initializeGame(String gameChoice) {
        MinigameFactory gameFactory = new MinigameFactory();
        Minigame game = gameFactory.getMinigame(gameChoice);
        gameRunning = true;
        game.play();
        game.endGame();
    }

    public abstract void play();

    public void endGame(){
        System.out.println("The minigame is being shutdown ");
        gameRunning = false;
    }
}
