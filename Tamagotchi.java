package softwaredesign;

public class Tamagotchi extends Pet{
    public int cleanlinessBar = 80;
    public int hungerBar = 80;
    public int moodBar = 80;
    public int energyBar = 80;
    public int timeAlive = 0;

    public void cleanPet(){
        System.out.print("cleaning your pet:\n");
        cleanlinessBar+=20;
        System.out.print("Your pets cleanliness level is now: " + cleanlinessBar + "\n");
    }
    public void feedPet(){
        System.out.print("feeding your pet:\n");
        hungerBar+=20;
        System.out.print("Your pets hunger level is now: " + hungerBar + "\n");
    }
    public void playPet(){
        System.out.print("playing with your pet:\n");
        moodBar+=20;
        System.out.print("Your pets mood level is now: " + moodBar + "\n");
    }
    public void sleepPet(){}
    public void wakePet(){}
}
