package softwaredesign;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
import java.util.Arrays;

public class UserProfile{
    public String username = "";
    private String password = "";
    public boolean loggedIn = false;
    public ArrayList<Tamagotchi> petList = new ArrayList<Tamagotchi>();

    public void createAccount(){
        createUsername();
        createPassword();
    }
    public static boolean accountInitialize(ArrayList<UserProfile> Users,int UserCount,int currentUserIndex){
        boolean accountExist = false;
        while(!accountExist){
            System.out.print("Type (create) to create an account\n");
            System.out.print("Type (login) to login to an account\n");
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine().toLowerCase();
            if(input.equals("create")){
                Users.add(new UserProfile());
                UserProfile currentUser = Users.get(UserCount);
                currentUserIndex = UserCount;
                UserCount++;
                currentUser.createAccount();
                accountExist = true;
                UserInputSingleton.getInstance().Users = Users;
                UserInputSingleton.getInstance().UserCount = UserCount;
                UserInputSingleton.getInstance().currentUserIndex = currentUserIndex;
            }
            else if(input.equals("login")){
                System.out.print("Enter your username: \n");
                String name = scanner.nextLine().toLowerCase();
                for (int i = 0; i < Users.size(); i++) {
                    if(Objects.equals(Users.get(i).username, name)){
                        currentUserIndex = i;
                        UserInputSingleton.getInstance().currentUserIndex = currentUserIndex;
                        System.out.print("Existing Username \n");
                        accountExist = Users.get(i).enterUsername();
                    }
                }
            }
        }
        return accountExist;
    }
    public boolean enterUsername(){
        enterPassword();
        return loggedIn;
    }
    public void enterPassword(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Now enter your password: \n");
        String pass = scanner.nextLine().toLowerCase();
        if(pass.equals(password)){
            System.out.print("Your account has been found successfully!: \n");
            loggedIn = true;
        }
        else{
            System.out.print("Incorrect password! \n");
        }
    }
    private void createUsername(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("First type in your preferred username: \n");
        username = scanner.nextLine().toLowerCase();
    }
    private void createPassword(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Now type in your preferred password: \n");
        password = scanner.nextLine().toLowerCase();
        System.out.print("Your account has been created successfully!: \n");
    }

}
