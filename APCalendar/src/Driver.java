public class Driver
{
    public static void main(String[] args)
    {
        APCalendar calendar = new APCalendar();
        System.out.println(calendar.numberOfLeapYears(2000, 2020));
        System.out.println(calendar.dayOfWeek(5, 28, 2006));
    }
}