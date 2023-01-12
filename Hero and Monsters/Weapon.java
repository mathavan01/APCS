public class Weapon extends Accessories
{
    private int dmg;
    private String name;
    private int crit_rate;
    private double crit_damage;
    public Weapon(int dmg, String name, int crit_rate, double crit_damage)
    {
        this.dmg = dmg;
        this.name = name;
        this.crit_rate = crit_rate;
        this.crit_damage = crit_damage;
    }
    public int getDamage()
    {
        return dmg;
    }
    public String getName()
    {
        return name;
    }
    public int getCRate()
    {
        return crit_rate;
    }
    public double getCDmg()
    {
        return crit_damage;
    }
}
