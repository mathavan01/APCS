public class Armor extends Accessories
{
    private double damageAbsorption;
    public String name;
    public Armor(double damageAbsorption, String name)
    {
        this.damageAbsorption = damageAbsorption;
        this.name = name;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public double getAbsorption()
    {
        return damageAbsorption;
    }
    public void setAbsorption(double absorption)
    {
        damageAbsorption = absorption;
    }
}
