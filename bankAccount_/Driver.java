import java.util.ArrayList;

public class Driver{
    public static void main(String args[]){
        ArrayList<String> newClients = new ArrayList<String>();
        
        newClients.add("Dan Lee d l 42000.01 78000.12");
        newClients.add("Ted Lee t l 40200.01 70800.12");
        newClients.add("Red Lee r l 40020.01 70080.12");
        newClients.add("Phil Lee p l 40002.01 70008.12");
        
        newClients.add("Ben Lee b l 43000.01 73000.12");
        newClients.add("Yul Lee y l 40300.01 70300.12");
        newClients.add("Luk Lee l l 40030.01 70030.12");
        newClients.add("Fred Lee f l 40003.01 70003.12");
        
        newClients.add("Ned Lee n l 47000.01 76000.12");
        newClients.add("Wen Lee w l 40700.01 70600.12");
        newClients.add("Mo Lee m l 40070.01 70060.12");
        newClients.add("Nell Lee nl l 40007.01 70006.12");
        
        newClients.add("Gad Lee g l 49000.01 74000.12");
        newClients.add("Ill Lee i l 40900.01 70400.12");
        newClients.add("Pill Lee pl l 40090.01 70040.12");
        newClients.add("Dill Lee d l 40009.01 70004.12");
        
        CorporateOffice corp = new CorporateOffice(newClients);
        corp.login();
    }
}