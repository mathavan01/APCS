import java.util.*;
public class Customer
{
    private String name;
    private int idNum;
    public Customer(String name, int idNum){
        this.name = name;
        this.idNum = idNum;
    }
    public String getName(){
        return name;
    }
    public int getID(){
        return idNum;
    }
    public int compareCustomer(Customer other){
        if (name.compareTo(other.getName()) == 0){
            if (idNum == other.getID()){
                return 0;
            } else{
                return idNum - other.getID();
            }
        } else {
            return name.compareTo(other.getName());
        }
    }
    public void prefixMerge(Customer[] list1, Customer[] list2, Customer[] result){
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < result.length; i++){        
            if (list1[i].compareCustomer(list2[i]) < 0){
                result[i] = list1[c1];
                c1++;
            } else if (list1[i].compareCustomer(list2[i]) > 0){
                result[i] = list2[i];
                c2++;
            } else {
                result[i] = list1[c1];
            }          
        }
    }
}
