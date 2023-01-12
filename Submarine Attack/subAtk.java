import java.io.*;
import java.util.*;
import java.util.Scanner;
public class subAtk{
    static final int win_Length = 300;
    static final int win_Height = 300;
    public static void main(String[] args){
        while (true){
            System.out.println("Submarine has been spotted!");
            int s_l = 10 + (int)(Math.random() * ((20 - 10) + 1));
            int s_h = 40 + (int)(Math.random() * ((70 - 40) + 1));
            int s_x = 10 + (int)(Math.random() * (((win_Length - s_l) - 0) + 1));
            int s_y = 10 + (int)(Math.random() * (((win_Height - s_h) - 0) + 1));
            int subHP = 100;
            Scanner targetCoord = new Scanner(System.in);
            for (int i = 0; i < 5; i++){
                System.out.print("Enter the x position of the depth charge:");
                String sxPos = targetCoord.nextLine();
                int xPos = (Integer.parseInt(sxPos));
                while (xPos < 30 || xPos > 270){
                    if (xPos < 30 && xPos > 0 || xPos < 300 && xPos > 270){
                        System.out.println("Error! The charge must explode within the spotted area!");
                        System.out.print("Re-enter the x position of the depth charge:");
                        sxPos = targetCoord.nextLine();
                        xPos = (Integer.parseInt(sxPos));
                    }else{
                        System.out.println("Error! The submarine is within this 300x300 meter area!");
                        System.out.print("Re-enter the x position of the depth charge:");
                        sxPos = targetCoord.nextLine();
                        xPos = (Integer.parseInt(sxPos));
                    }
                    if (xPos > 30 && xPos < 270){
                        break;
                    }
                }
                System.out.print("Enter the y position of the depth charge:");
                String syPos = targetCoord.nextLine();
                int yPos = (Integer.parseInt(syPos));
                while (yPos < 30 || yPos > 270){
                    if (yPos < 30 && yPos > 0 || yPos < 300 && yPos > 270){
                        System.out.println("Error! The charge must explode within the spotted area!");
                        System.out.print("Re-enter the y position of the depth charge:");
                        syPos = targetCoord.nextLine();
                        yPos = (Integer.parseInt(syPos));
                    }else{
                        System.out.println("Error! The submarine is within this 300x300 meter area!");
                        System.out.print("Re-enter the y position of the depth charge:");
                        syPos = targetCoord.nextLine();
                        yPos = (Integer.parseInt(syPos));
                    }
                    if (yPos > 30 && yPos < 270){
                        break;
                    }
                }
                if (intersect(xPos, yPos, s_l, s_h, s_x, s_y) == 1){
                    System.out.println("** Direct Hit! **");
                    subHP -= 100;
                    break;
                }else if (intersect(xPos, yPos, s_l, s_h, s_x, s_y) == 2){
                    System.out.println("** Indirect Hit! **");
                    subHP -= 50;
                    if (subHP == 0){
                        break;
                    }
                }else {
                    System.out.println("** Intelligence shows the submarine has not taken damage. **");
                }
            }
            if (subHP != 0){
                System.out.println("You failed to sink the submarine before it escaped!");
                System.out.println("\n" + "Another submarine has been spotted! Would you like to engage?");
                String choice = targetCoord.nextLine();
                if (choice.equals("No") || choice.equals("no")){
                    break;
                }
            }else{
                System.out.println("The submarine has been destroyed!");
                System.out.println("\n" + "Another submarine has been spotted! Would you like to engage?");
                String choice = targetCoord.nextLine();
                if (choice.equals("No") || choice.equals("no")){
                    break;
                }
            }
        }
    }
    public static int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }
    public static int intersect(int cX, int cY, int s_l, int s_h, int sub_x, int sub_y){
        float closestX = clamp(cX, sub_x, (sub_x + s_l));
        float closestY = clamp(cY, sub_y, (sub_y + s_h));
        float distanceX = cX - closestX;
        float distanceY = cY - closestY;
        float distanceSquared = (distanceX * distanceX) + (distanceY * distanceY);
        if(distanceSquared < Math.pow(50, 2) && distanceSquared < Math.pow(30, 2)){
            return 1;
        }else if (distanceSquared < Math.pow(50, 2)){
            return 2;
        }else {
            return 3;
        }
    }
}