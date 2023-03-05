import java.util.*;
public class FrogSimulation
{
    private int goalDistance;
    private int maxHops;
    public FrogSimulation(int dist, int numHops){
        goalDistance = dist;
        maxHops = numHops;
    }
    private int hopDistance(){
        return (int) ((Math.random() * (30 + 10)) - 10);
    }
    public boolean simulate(){
        int pos = 0;
        for (int i = 0; i < maxHops; i++){
            pos += hopDistance();
            if (pos >= goalDistance){
                return true;
            }
            if (pos < 0){
                break;
            }
        }
        return false;
    }
    public double runSimulations(int num){
        double success = 0;
        for (int i = 0; i < num; i++){
            if (simulate()){
                success++;
            }
        }
        return success / num;
    }
}
