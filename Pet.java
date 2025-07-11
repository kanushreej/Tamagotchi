package softwaredesign;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public abstract class Pet {
    public String petName = "";
    public static int petCount = 0;
    public String enterPetName(){
        System.out.println("Name your new pet: ");
        Scanner scanner = new Scanner(System.in);
        petName = scanner.nextLine().toLowerCase();
        return petName;
    }
    public void createPet(){
        Tamagotchi pet = new Tamagotchi();
        Accessibility access = new Accessibility(pet);
        petCount++;
    }
    public void deathPet(){
        int currentUserIndex = UserInputSingleton.getInstance().currentUserIndex;
        ArrayList<UserProfile> Users = UserInputSingleton.getInstance().Users;
        for (int i = 0; i < Users.get(currentUserIndex).petList.size(); i++) {
            if (!(Users.get(currentUserIndex).petList.get(i) == null) && Users.get(currentUserIndex).petList.get(i).petName.equals(this.petName)) {
                Users.get(currentUserIndex).petList.remove(i);
            }
        }
        UserInputSingleton.getInstance().Users = Users;
    }
}
