import java.io.*;
import java.util.*;
import java.util.Scanner;

public class dataVal
{
    public static void main(String[] args)
    {
        while(true){
            Scanner login = new Scanner(System.in);
            System.out.println("Welcome to the \"Account Creator\"!");
            System.out.println("Enter your First Name: ");
            String firstName = login.nextLine();
            while (!allAlpha(firstName)){
                System.out.println("Error! Your name cannot contain a number.");
                System.out.println("Re-enter your First Name: ");
                firstName = login.nextLine();
                if (allAlpha(firstName)){
                    break;
                }
            }
            System.out.println("Enter your Last Name: ");
            String lastName = login.nextLine();
            while (!allAlpha(lastName)){
                System.out.println("Error! Your last name cannot contain a number and have at least 2 letters.");
                System.out.println("Re-enter your Last Name: ");
                lastName = login.nextLine();
                if (allAlpha(lastName)){
                    break;
                }
            }
            System.out.println("Enter your Zip Code: ");
            String zipCode = login.nextLine();
            while (!isNumString(zipCode)){
                System.out.println("Error! Your zipcode cannot contain a letter and must contain 5 digits.");
                System.out.println("Re-enter your Zip Code: ");
                zipCode = login.nextLine();
                if (isNumString(zipCode)){
                    break;
                }
            }
            System.out.println("Enter your Year of Birth: ");
            int birthYear = login.nextInt();
            while (!year_of_birth(birthYear)){
                System.out.println("Error! Your year of birth cannot be before 1904.");
                System.out.println("Re-enter your Year of Birth: ");
                birthYear = login.nextInt();
                if (year_of_birth(birthYear)){
                    break;
                }
            }
            String phoneNum = login.nextLine();
            System.out.println("Enter your Phone Number: ");
            phoneNum = login.nextLine();
            while (!phoneNumber(phoneNum)){
                System.out.println("Error! Your phone number must follow the appropriate format.");
                System.out.println("Re-enter your Phone Number: ");
                phoneNum = login.nextLine();
                if (phoneNumber(phoneNum)){
                    break;
                }
            }
            System.out.println("Enter your Email: ");
            String email = login.nextLine();
            while (!emailAddress(email)){
                System.out.println("Error! Your email must follow the appropriate format.");
                System.out.println("Re-enter your Email: ");
                email = login.nextLine();
                if (emailAddress(email)){
                    break;
                }
            }
            System.out.println("Enter your Username: ");
            String userName = login.nextLine();
            System.out.println("Enter your Password: ");
            String password = login.nextLine();
            while (!passWord(password)){
                System.out.println("Error! Your password must have at least 8 characters, 2 numbers, 1 uppercase letter, and 1 lowercase letter.");
                System.out.println("Re-enter your Password: ");
                password = login.nextLine();
                if (passWord(password)){
                    break;
                }
            }
            System.out.println("Re-enter your Password: ");
            String password2 = login.nextLine();
            while (!password2.equals(password)){
                System.out.println("Passwords do not match. Please re-enter.");
                System.out.println("Re-enter your Password: ");
                password2 = login.nextLine();
                if (password2.equals(password)){
                    break;
                }
            }
            System.out.println("\n" + "** You have successfully created your account! **" + "\n");
            System.out.println("Enter your Username: ");
            String enteredUsername = login.nextLine();
            System.out.println("Enter your Password: ");
            String enteredPass = login.nextLine();
            while (!enteredUsername.equals(userName) || !enteredPass.equals(password)){
                System.out.println("Error! Those credentials were not recognized.");
                System.out.println("Re-enter your Username and Password: ");
                System.out.println("Enter your Username: ");
                enteredUsername = login.nextLine();
                System.out.println("Enter your Password: ");
                enteredPass = login.nextLine();
                if (enteredUsername.equals(userName) && enteredPass.equals(password)){
                    break;
                }
            }
            System.out.println("\n" + "** You have successfully entered the system! **" + "\n");
            break;
        }
    }
    public static boolean allAlpha(String str)
    {
        int count = 0;
        if (str.length() <= 2){
            return false;
        }
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) > 64 && str.charAt(i) < 91||(str.charAt(i) > 96 && str.charAt(i) < 123)){
                count++;
                if (count == str.length()){
                    return true;
                }
            } else{
                return false;
            }
        }
        return false;
    }
    public static boolean isNumString(String str)
    {
        int count2 = 0;
        if (str.length() < 5||str.length() > 5){
            return false;
        }
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) > 47 && str.charAt(i) < 58){
                count2++;
                if (count2 == str.length()){
                    return true;
                }
            } else{
                return false;
            }
        }
        return false;
    }
    public static boolean year_of_birth(int integer)
    {
        for (int i = 0; i < 1; i++){
            if (integer >= 1904 && integer <= 2022){
                return true;
            } else{
                return false;
            }
        }
        return false;
    }
    public static boolean phoneNumber(String str)
    {
        if (str.length() < 12||str.length() > 12){
            return false;
        }
        for (int i = 0; i < str.length(); i++){
            if ((str.charAt(i) > 47 && str.charAt(i) < 58 || str.charAt(i) == 45) && str.substring(3,4).equals("-") && str.substring(7,8).equals("-")){
                return true;
            } else{
                return false;
            }
        }
        return false;
    }
    public static boolean emailAddress(String str)
    {
        int count = 0;
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) == 64){
                count++;
            }
        }
        if (count != 1){
            return false;
        }
        if (str.indexOf('.') == -1){
            return false;
        }
        String domain = str.substring(str.indexOf('@')+1, str.length());
        for (int i = 0; i < domain.length(); i++){
            if (domain.charAt(i) >= 64 && str.charAt(i) < 91||str.charAt(i) > 96 && str.charAt(i) < 123||(str.charAt(i) == 46||str.charAt(i) == 45) && (str.length() >= 2 && str.length() <=63)){
                if (domain.indexOf('.') != -1){
                    return true;
                }
            } else{
                return false;
            }
        }
        return false;
    }
    public static boolean passWord(String str)
    {
        int numCount = 0;
        int upperCount = 0;
        int lowerCount = 0;
        if (str.length() < 8){
            return false;
        }
        for (int i = 0; i < str.length(); i++){
            if (str.charAt(i) > 32 && str.charAt(i) < 123){
                if (str.charAt(i) > 47 && str.charAt(i) < 58){
                    numCount++;
                }
                if (str.charAt(i) > 64 && str.charAt(i) < 91){
                    upperCount++;
                }
                if (str.charAt(i) > 96 && str.charAt(i) < 123){
                    lowerCount++;
                }
                if (numCount >= 2 && upperCount >= 1 && lowerCount >= 1){
                    return true;
                }
            } else{
                return false;
            }
        }
        return false;
    }
}