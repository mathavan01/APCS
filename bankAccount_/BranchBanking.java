import java.util.ArrayList;

public class BranchBanking{
    private ArrayList<Client> clientList = new ArrayList<Client>();
    
    public BranchBanking(ArrayList<Client> clients){
        for (Client item : clients) {
            clientList.add(item);
        }      
    }
    public String getClient(String username, String password)
    {
        for (Client i: clientList){
            if (i.getUsername().equals(username) && i.getPassword().equals(password)){
                return i.getFullName();
            }
        }
        return "Client not found";
    }
    public String getClientFName(String username, String password)
    {
        for (Client i: clientList){
            if (i.getUsername().equals(username) && i.getPassword().equals(password)){
                return i.getFirstName();
            }
        }
        return "Client not found";
    }
    public String getClientLName(String username, String password)
    {
        for (Client i: clientList){
            if (i.getUsername().equals(username) && i.getPassword().equals(password)){
                return i.getLastName();
            }
        }
        return "Client not found";
    }
    public double getMoney()
    {
        double moneyMade = 0;
        for (Client i : clientList){
            moneyMade += (i.getPersonalBalance() + i.getBuisnessBalance());
        }
        return moneyMade;
    }
    public double getPerMoney()
    {
        double moneyMade = 0;
        for (Client i : clientList){
            moneyMade += i.getPersonalBalance();
        }
        return moneyMade;
    }
    public double getBusMoney()
    {
        double moneyMade = 0;
        for (Client i : clientList){
            moneyMade += i.getBuisnessBalance();
        }
        return moneyMade;
    }
    public ArrayList getClientList()
    {
        return clientList;
    }
    public String getBusAcctInfo()
    {
        String str = "";
        for (Client i : clientList) {
            str += i.getFullName() + " (Buisness Balance): " + i.getBuisnessBalance() + "\n";
        }
        return str;
    }
    public String getPerAcctInfo()
    {
        String str = "";
        for (Client i : clientList) {
            str += i.getFullName() + " (Personal Balance): " + i.getPersonalBalance() + "\n";
        }
        return str;
    }
    public void Deposit(String fname, String lname, String account, double money)
    {
        for (Client i : clientList) {
            if (i.getFullName().equals(fname + " " + lname)){
                i.deposit(money, account);
            }
        }
    }
    public void Withdraw(String fname, String lname, String account, double money)
    {
        for (Client i : clientList) {
            if (i.getFullName().equals(fname + " " + lname)){
                i.withdrawal(money, account);
            }
        }
    }
    public void Balance(String fname, String lname, String account)
    {
        for (Client i : clientList) {
            if (i.getFullName().equals(fname + " " + lname)){
                i.balance(account);
            }
        }
    }
    public String toString(){
        String str = "";
        for (Client i : clientList) {
            str += i.toString() + "\n";
        }
        return str;
    }
}