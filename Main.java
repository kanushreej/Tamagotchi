package softwaredesign;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        UserInputSingleton instance1 = UserInputSingleton.getInstance();
        instance1.readUserCommand();
    }
}