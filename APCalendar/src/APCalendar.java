public class APCalendar
{
    public static boolean isLeapYear(int year){
        if (year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)){
            return true;
        }
        return false;
    }
    public static int numberOfLeapYears(int year1, int year2){
        int numLeapYears = 0;
        for (int i = year1; i <= year2; i++){
            if (isLeapYear(i)){
                numLeapYears++;
            }
        }
        return numLeapYears;
    }
    public static int firstDayOfYear(int year){
        int base = 2019;
        int baseYear = 2;
        if (year < base){
            int diff = numberOfLeapYears( year,  base) + (base-year);
            diff = diff%7;
            baseYear = (2-diff);
            if (baseYear< 0){
                baseYear = 7 + baseYear;
            }
            return baseYear;
        }else{
            for (int i = base; i < year; i++){
                baseYear += 1;
                if (isLeapYear(i)){
                    baseYear ++;
                }
            }
            return baseYear%7;
        }
    }
    public static int dayOfYear(int month, int day, int year){
        int[] months  = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        month -= 1;
        if (isLeapYear(year)){
            months[1] ++;
        }
        int total = 0;
        for (int i = 0; i < month; i++){
            total += months[i];
        }
        total += day;
        return total;
    }
    public static int dayOfWeek(int month, int day, int year) {
        int days_from_week_start =  firstDayOfYear(year) + dayOfYear(month, day, year) - 1;
        return days_from_week_start % 7;
    }
}