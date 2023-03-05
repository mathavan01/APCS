import java.util.*;
public class Driver
{
    public static void main(String[] args){
        Customer c1 = new Customer("Arthur", 4920);
        Customer c2 = new Customer("Burton", 4920);
        Customer c3 = new Customer("Burton", 4920);
        Customer c4 = new Customer("Franz", 4920);
        Customer c5 = new Customer("Horton", 4920);
        Customer c6 = new Customer("Jones", 4920);
        Customer c7 = new Customer("Miller", 4920);
        Customer c8 = new Customer("Nguyen", 4920);
        Customer[] list1 = {c1, c2, c3, c4, c5, c6, c7, c8};
        Customer c9 = new Customer("Aaron", 4920);
        Customer c10 = new Customer("Baker", 4920);
        Customer c11 = new Customer("Burton", 4920);
        Customer c12 = new Customer("Dillard", 4920);
        Customer c13 = new Customer("Jones", 4920);
        Customer c14 = new Customer("Miller", 4920);
        Customer c15 = new Customer("Noble", 4920);
        Customer[] list2 = {c9, c10, c11, c12, c13, c14, c15};
        Customer[] result = new Customer[6];
        System.out.println(Arrays.toString(result));
        c1.prefixMerge(list1, list2, result);
        System.out.println(Arrays.toString(result));
    }
}
