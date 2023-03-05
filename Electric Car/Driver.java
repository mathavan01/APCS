public class Driver
{
    public static void main(String[] args)
    {
        int[] rateTable = {50, 60, 160, 60, 80, 100, 100, 120, 150, 150, 150, 200, 
                           40, 240, 220, 220, 200, 200, 180, 190, 140, 100, 80, 60};
        BatteryCharger c = new BatteryCharger(rateTable);
        System.out.println(c.getChargingCost(0, 5));
        System.out.println(c.getChargeStartTime(5));
    }
}
