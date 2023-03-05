public class BatteryCharger
{
    private int[] rateTable;
    public BatteryCharger(int[] rateTable){
        this.rateTable = rateTable;
    }
    public int getChargingCost(int startHour, int chargeTime){
        int totalCost = 0;
        for (int i = startHour; i < startHour + chargeTime; i++){
            totalCost += rateTable[i % 24];
        }
        return totalCost;
    }
    public int getChargeStartTime(int chargeTime){
        int lowestCost = Integer.MAX_VALUE;
        int startTime = 0;
        for (int i = 0; i < 24; i++){
            if (getChargingCost(i, chargeTime) < lowestCost){
                lowestCost = getChargingCost(i, chargeTime);
                startTime = i;
            }
        }
        return startTime;
    }
}
