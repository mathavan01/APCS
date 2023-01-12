public class Client
{
    private String fname;
    private String lname;
    private String username;
    private String password;
    private float per_bal;
    private float bus_bal;
    public Client(String f, String l, String u, String p, float pb, float bb)
    {
        fname = f;
        lname = l;
        username = u;
        password = p;
        per_bal = pb;
        bus_bal = bb;
    }
    public double getPersonalBalance()
    {
        return per_bal;
    }
    public double getBuisnessBalance()
    {
        return bus_bal;
    }
    public String getUsername()
    {
        return username;
    }
    public String getPassword()
    {
        return password;
    }
    public String getFullName()
    {
        return fname + " " + lname;
    }
    public String getFirstName()
    {
        return fname;
    }
    public String getLastName()
    {
        return lname;
    }
    public void deposit(double money, String account)
    {
        if (account.equals("personal")){
            per_bal += money;
        }else if (account.equals("buisness")){
            bus_bal += money;
        }else {
            System.out.println("Error! please enter a valid account name");
        }
    }
    public void withdrawal(double money, String account)
    {
        if (account.equals("personal")){
            per_bal -= money;
        }else if (account.equals("buisness")){
            bus_bal -= money;
        }else {
            System.out.println("Error! please enter a valid account name");
        }
    }
    public void balance(String account)
    {
        if (account.equals("personal")){
            System.out.println("Your personal balance is $" + per_bal);
        }else if (account.equals("buisness")){
            System.out.println("Your buisness balance is $" + bus_bal);
        }else {
            System.out.println("Error! please enter a valid account name");
        }
    }
    public String toString(){
        return "First Name: " + fname + "\nLast Name: " + lname + "\nPersonal Balance: " + per_bal + "\nBuisness Balance: " + bus_bal + "\n";
    }
}