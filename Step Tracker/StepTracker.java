import java.util.*;
public class StepTracker
{
    int stepThreshold;
    int totalSteps;
    int totalDays;
    List<Integer> days;
    public StepTracker(int stepThreshold){
        this.stepThreshold = stepThreshold;
        totalSteps = 0;
        totalDays = 0;
        days = new ArrayList<Integer>();
    }
    public void addDailySteps(int steps){
        if (steps >= stepThreshold){
            days.add(steps);
        }
        totalSteps += steps;
        totalDays++;
    }
    public int activeDays(){
        return days.size();
    }
    public double averageSteps(){
        if (totalDays > 0){
            return totalSteps / totalDays;
        }
        return 0;
    }
}
