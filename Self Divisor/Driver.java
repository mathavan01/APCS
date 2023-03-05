import java.util.*;
public class Driver
{
    public static void main(String[] args){
        System.out.println(SelfDivisor.isSelfDivisor(138));
        System.out.println(SelfDivisor.isSelfDivisor(128));
        System.out.println(Arrays.toString(SelfDivisor.firstNumSelfDivisors(10, 3)));
        System.out.println(Arrays.toString(SelfDivisor.firstNumSelfDivisors(100, 3)));
    }
}
