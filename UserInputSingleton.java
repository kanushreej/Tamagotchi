package softwaredesign;

import java.nio.file.attribute.UserPrincipal;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class UserInputSingleton {
    public Scanner scanner = new Scanner(System.in);
    private static UserInputSingleton instance = new UserInputSingleton();
    public static UserInputSingleton getInstance(){
        return instance;
    }
    //All following variables are a temporary way to store userprofiles
    public ArrayList<UserProfile> Users = new ArrayList<>();
    public int UserCount = 0;
    public int currentUserIndex = 0;
    public boolean loggedIn = false;
    public void readUserCommand(){
        label:
        while (true){
            while(!loggedIn){
                loggedIn = UserProfile.accountInitialize(this.Users,this.UserCount,this.currentUserIndex);
            }
            System.out.print("Type (quit) to exit the code\n");
            System.out.print("Type (minigame) If you want to play a minigame\n");
            System.out.print("Type (pet) If you want to start interacting with a pet\n");
            System.out.print("Type (logout) If you want to exit from current account\n");
            String input = scanner.nextLine().toLowerCase();
            switch (input) {
                case "minigame": {
                    System.out.println("What game do you want to play?: ");
                    System.out.println("Choices: RockPaperScissors(type: 1)");
                    String playerChoice = scanner.nextLine().toLowerCase();
                    if (playerChoice.equals("1")) {
                        Minigame.initializeGame("1");
                    }
                    break;
                }
                case "logout": {
                    loggedIn = false;
                    break;
                }
                case "quit":
                    break label;
                case "pet": {
                    System.out.print("Type (create) If you want to create a pet\n");
                    System.out.print("Type (petname-...) If you want to interact with your pet\n");
                    System.out.print("Interaction choices are: feed,pet,play \n");
                    Scanner scanner = new Scanner(System.in);
                    String playerChoice = scanner.nextLine().toLowerCase();
                    if (playerChoice.equals("create")) {
                        int PetCount = Users.get(currentUserIndex).petList.size();
                        if (PetCount >= 3) {
                            System.out.print("You already have the maximum amount of pets(3)\n");
                        } else {
                            Users.get(currentUserIndex).petList.add(new Tamagotchi());
                            System.out.print("good?\n");
                            Users.get(currentUserIndex).petList.get(PetCount).enterPetName();
                        }
                    } else {
                        int petNameLength = playerChoice.indexOf("-");
                        String petName = null;
                        String action = "";
                        if (petNameLength != -1) {
                            petName = playerChoice.substring(0, petNameLength);
                            action = playerChoice.substring(petNameLength + 1);
                        }
                        if (action.equals("feed") || action.equals("clean") || action.equals("play")) {
                            boolean foundPet = false;
                            for (int i = 0; i < Users.get(currentUserIndex).petList.size(); i++) {
                                if (!(Users.get(currentUserIndex).petList.get(i) == null) && Users.get(currentUserIndex).petList.get(i).petName.equals(petName)) {
                                    if (action.equals("feed")) {
                                        Users.get(currentUserIndex).petList.get(i).feedPet();
                                    } else if (action.equals("clean")) {
                                        Users.get(currentUserIndex).petList.get(i).cleanPet();
                                    } else {
                                        Users.get(currentUserIndex).petList.get(i).playPet();
                                    }
                                    foundPet = true;
                                    break;
                                }
                            }
                            if (!foundPet) {
                                System.out.print("That pet does not exist\n");
                            }
                        } else {
                            System.out.print("That action does not exist\n");
                        }
                    }
                    break;
                }
            }
        }
    }
}
