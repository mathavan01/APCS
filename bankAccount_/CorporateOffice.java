import java.util.ArrayList;
import java.util.*;
public class CorporateOffice{
    private ArrayList<BranchBanking> branchList = new ArrayList<BranchBanking>();
    public CorporateOffice(ArrayList<String> clientInformation){
        ArrayList<Client> clientList = new ArrayList<Client>();
        
        String fname;
        String lname;
        String user;
        String pass;
        float per_bal;
        float bus_bal;
        
        for (int i = 0; i < 4; i++) {
            String[] parts = clientInformation.get(i).split(" ");
            
            fname = parts[0];
            lname = parts[1];
            user = parts[2];
            pass = parts[3];
            per_bal = Float.valueOf(parts[4]);
            bus_bal = Float.valueOf(parts[5]);
            
            clientList.add(new Client(fname, lname, user, pass, per_bal, bus_bal));
        }
        branchList.add(new BranchBanking(clientList));
        clientList.clear();
        
        for (int i = 4; i < 8; i++) {
            String[] parts = clientInformation.get(i).split(" ");
            
            fname = parts[0];
            lname = parts[1];
            user = parts[2];
            pass = parts[3];
            per_bal = Float.valueOf(parts[4]);
            bus_bal = Float.valueOf(parts[5]);
            
            clientList.add(new Client(fname, lname, user, pass, per_bal, bus_bal));
        }
        branchList.add(new BranchBanking(clientList));
        clientList.clear();
        
        for (int i = 8; i < 12; i++) {
            String[] parts = clientInformation.get(i).split(" ");
            
            fname = parts[0];
            lname = parts[1];
            user = parts[2];
            pass = parts[3];
            per_bal = Float.valueOf(parts[4]);
            bus_bal = Float.valueOf(parts[5]);
            
            clientList.add(new Client(fname, lname, user, pass, per_bal, bus_bal));
        }
        branchList.add(new BranchBanking(clientList));
        clientList.clear();
        
        for (int i = 12; i < 16; i++) {
            String[] parts = clientInformation.get(i).split(" ");
            
            fname = parts[0];
            lname = parts[1];
            user = parts[2];
            pass = parts[3];
            per_bal = Float.valueOf(parts[4]);
            bus_bal = Float.valueOf(parts[5]);
            
            clientList.add(new Client(fname, lname, user, pass, per_bal, bus_bal));
        }
        branchList.add(new BranchBanking(clientList));
    }
    public String getClient(String username, String password)
    {
        for (BranchBanking i: branchList){
            if (!i.getClient(username, password).equals("Client not found")){
                return i.getClient(username, password);
            }
        }
        return "Client not found";
    }
    public boolean checkProfit()
    {
        double sumMoney = 0;
        double moneyEarned = 0;
        double expenses = 0;
        for (BranchBanking i : branchList){
            sumMoney += i.getMoney();
        }
        for (BranchBanking i : branchList){
            expenses += 12 * 7000;
        }
        moneyEarned = 0.05 * sumMoney;
        if (moneyEarned > expenses){
            return true;
        }
        return false;
    }
    public boolean profitPer()
    {
        double sumMoney = 0;
        double moneyEarned = 0;
        double expenses = 0;
        for (BranchBanking i : branchList){
            sumMoney += i.getPerMoney();
        }
        for (BranchBanking i : branchList){
            expenses += 12 * 0.4 * 7000;
        }
        moneyEarned = 0.05 * sumMoney;
        
        if (moneyEarned > expenses){
            return true;
        }
        return false;
    }
    public boolean profitBus()
    {
        double sumMoney = 0;
        double moneyEarned = 0;
        double expenses = 0;
        for (BranchBanking i : branchList){
            sumMoney += i.getBusMoney();
        }
        for (BranchBanking i : branchList){
            expenses += 12 * 0.6 * 7000;
        }
        moneyEarned = 0.05 * sumMoney;
        if (moneyEarned > expenses){
            return true;
        }
        return false;
    }
    public String getBuisnessInfo()
    {
        String str = "";
        for (BranchBanking i: branchList){
            str += i.getBusAcctInfo();
        }
        return str;
    }
    public String getPersonalInfo()
    {
        String str = "";
        for (BranchBanking i: branchList){
            str += i.getPerAcctInfo();
        }
        return str;
    }
    public void login(){
        Scanner input = new Scanner(System.in);
        String choice;
        System.out.println("** Welcome to the \"Bank\"! **\n");
        System.out.println("Enter you Username: ");
        String username = input.nextLine();
        System.out.println("Enter you Password: ");
        String password = input.nextLine();
        if (!password.equals("-1") || !username.equals("-1")){
            System.out.println("Welcome, " + getClient(username, password));
            String[] parts = getClient(username, password).split(" ");
            String firstname = parts[0];
            String lastname = parts[1]; 
            while (true){
                System.out.println("\n1.\tDeposit");
                System.out.println("2.\tWithdraw");
                System.out.println("3.\tPrint out Balance");
                System.out.println("\nChoose an option: ");
                choice = input.nextLine();
                if (choice.equals("-1")){
                    System.out.println("\n\n** Thank You! ** ");
                        break;
                }
                switch (choice){
                    case "1":
                        System.out.println("Enter amount to deposit: ");
                        double deposit = input.nextDouble();
                        String account = input.nextLine();
                        System.out.println("Personal or Buisness account?");
                        account = input.nextLine();
                        for (BranchBanking i: branchList){
                            i.Deposit(firstname, lastname, account, deposit);
                        }
                        break;
                    case "2":
                        System.out.println("Enter amount to withdraw: ");
                        double withdrawal = input.nextDouble();
                        String account2 = input.nextLine();
                        System.out.println("Personal or Buisness account?");
                        account2 = input.nextLine();
                        for (BranchBanking i: branchList){
                            i.Withdraw(firstname, lastname, account2, withdrawal);
                        }
                        break;
                    case "3":
                        System.out.println("Personal or Buisness account?");
                        String account3 = input.nextLine();
                        for (BranchBanking i: branchList){
                            i.Balance(firstname, lastname, account3);
                        }
                        break;
                    default:
                        System.out.println("Error! Enter a number from 1-3.");
                        System.out.println("Choose an option again: ");
                        break;
                }
            }
        }
        if (password.equals("-1") && username.equals("-1")){
            while (true){
                System.out.println("** Regional Manager Account **");
                System.out.println("\n1.\tPrint out all client information.");
                System.out.println("2.\tPrint out all buisness account information.");
                System.out.println("3.\tPrint out all personal account information.");
                System.out.println("4.\tPrint out whether a monthly profit was earned.");
                System.out.println("5.\tPrint out whether a monthly profit was earned through Personal Banking.");
                System.out.println("6.\tPrint out whether a monthly profit was earned through Buisness Banking.");
                System.out.println("\nChoose an option: ");
                choice = input.nextLine();
                if (choice.equals("-1")){
                    System.out.println("\n\n** Thank You! ** ");
                        break;
                }
                switch (choice){
                    case "1":
                        for (BranchBanking i: branchList){
                            System.out.println(i.toString() + "\n");
                        }
                        break;
                    case "2":
                        System.out.println(getBuisnessInfo());
                        break;
                    case "3":
                        System.out.println(getPersonalInfo());
                        break;
                    case "4":
                        System.out.println(checkProfit());
                        break;
                    case "5":
                        System.out.println(profitPer());
                        break;
                    case "6":
                        System.out.println(profitBus());
                        break;
                    default:
                        System.out.println("Error! Enter a number from 1-6.");
                        System.out.println("Choose an option again: ");
                        break;
                }
            }
        }
    }
    public String toString()
    {
        String str = "";
        for (BranchBanking i : branchList){
            str += i.toString();
        }
        return str;
    }
}