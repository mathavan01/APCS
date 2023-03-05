
public class Driver
{
    public static void main(String[] args)
    {
        FrogSimulation sim = new FrogSimulation(24, 5);
        System.out.println(sim.simulate());
        System.out.println(sim.runSimulations(1000));
    }
}
