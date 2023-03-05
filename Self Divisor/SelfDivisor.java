public class SelfDivisor
{
    public static boolean isSelfDivisor(int num){
        String numString = Integer.toString(num);
        for (int i = 0; i < numString.length(); i++){
            if (Character.getNumericValue(numString.charAt(i)) == 0){
                return false;
            }
            if (Integer.parseInt(numString) % Character.getNumericValue(numString.charAt(i)) != 0){
                return false;
            }
        }
        return true;
    }
    public static int[] firstNumSelfDivisors(int start, int num){
        int[] arr = new int[num];
        for (int i = 0; i < arr.length; i++){
            while (arr[i] == 0){
                if (isSelfDivisor(start)){
                    arr[i] = start;
                }
                start++;
            }
        }
        return arr;
    }
}
