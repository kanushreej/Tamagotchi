package softwaredesign;

import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors extends Minigame {
    public String[] choices = {"rock", "paper", "scissors"};
    public int playerScore = 0;
    public int computerScore = 0;
    public Scanner scanner = new Scanner(System.in);
    public Random random = new Random();
    private int counter = 0;

    public void play() {
        while (counter!=3) {
            String playerChoice = setUserVal();
            if (!playerChoice.equals("rock") && !playerChoice.equals("paper") && !playerChoice.equals("scissors")) {
                System.out.println("Invalid choice, please try again!");
                continue;
            }
            String computerChoice = genRandVal();
            calculateOutcome(playerChoice,computerChoice);
        }
        showFinalScore();
    }
    private void showFinalScore(){
        if (playerScore > computerScore) {
            System.out.println("You won with " + playerScore + " points against computers' " + computerScore);
        } else if (computerScore > playerScore) {
            System.out.println("You lost with " + playerScore + " points against computers' " + computerScore);
        } else {
            System.out.println("You tied with " + playerScore + " points against computers' " + computerScore);
        }
    }
    private String setUserVal(){
        System.out.print("Enter your choice (rock, paper, or scissors): ");
        return scanner.nextLine().toLowerCase();
    }
    private String genRandVal(){
        int computerChoiceIndex = random.nextInt(choices.length);
        System.out.println("Computer chooses " + choices[computerChoiceIndex]);
        return choices[computerChoiceIndex];
    }
    private void calculateOutcome(String playerChoice, String computerChoice){
        if (playerChoice.equals(computerChoice)) {
            System.out.println("It's a tie!");
        } else if ((playerChoice.equals("rock") && computerChoice.equals("scissors")) ||
                (playerChoice.equals("paper") && computerChoice.equals("rock")) ||
                (playerChoice.equals("scissors") && computerChoice.equals("paper"))) {
            System.out.println("You win!");
            playerScore++;
            counter++;
        } else {
            System.out.println("Computer wins!");
            computerScore++;
            counter++;
        }
        System.out.println("Score: You - " + playerScore + ", Computer - " + computerScore);
    }
}
