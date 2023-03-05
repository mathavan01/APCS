import java.util.*;
public class Driver
{
    public static void main(String[] args){
        int[] hall = {1, 1, 2, 2};
        Robot robot = new Robot(hall, 0);
        System.out.println(robot.hallIsClear());
        System.out.println(robot.clearHall());
    }
}
