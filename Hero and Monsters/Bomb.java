public class Bomb extends Weapon
{
    private int x;
    private int y;
    public Bomb(int x, int y)
    {
        super(1000, "Bomb", 0, 0);
        this.x = x;
        this.y = y;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public void setX(int x)
    {
        this.x = x;
    }
    public void setY(int y)
    {
        this.y = y;
    }
}

