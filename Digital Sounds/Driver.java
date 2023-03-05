public class Driver
{
    public static void main(String[] args)
    {
        int[] samples1 = {40, 2532, 17, -2300, -17, -4000, 2000, 1048, -420, 33, 15, -32, 2030, 3223};
        int[] samples2 = {0, 0, 0, 0, -14, 0, -35, -39, 0, -7, 16, 32, 37, 29, 0, 0};
        Sound a = new Sound(samples1);
        Sound b = new Sound(samples2);
        System.out.println(a.limitAmplitude(2000));
        System.out.println(b.toString());
        b.trimSilenceFromBeginning();
        System.out.println(b.toString());
    }
}
