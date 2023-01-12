import java.util.*;
public class Hero extends Accessories
{
    private int x;
    private int y;
    private int hp;
    private int initialHP;
    private int direction;
    private int money;
    private int storageSpace;
    private int revives;
    private List<Potion> potions;
    private List<Bomb> bombs;
    private List<Weapon> weapon;
    private List<Armor> armor;
    SplittableRandom random = new SplittableRandom();
    public Hero()
    {
        x = 0;
        y = 14;
        hp = 1000;
        initialHP = hp;
        storageSpace = 2;
        armor = new ArrayList<Armor>();
        armor.add(new Armor(1, "Leather Armor"));
        weapon = new ArrayList<Weapon>();
        weapon.add(new Weapon((int) ((Math.random() * (30 - 10)) + 10), "Dagger", 5, 1.5));
        potions = new ArrayList<Potion>();
        bombs = new ArrayList<Bomb>();
    }
    public int getStorageSpace()
    {
        return storageSpace;
    }
    public void setStorageSpace(int newStorage)
    {
        storageSpace = newStorage;
    }
    public List<Potion> getPotionList()
    {
        return potions;
    }
    public List<Armor> getArmorList()
    {
        return armor;
    }
    public List<Weapon> getWeaponList()
    {
        return weapon;
    }
    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public int getHP()
    {
        return hp;
    }
    public int getInitialHP()
    {
        return initialHP;
    }
    public void usePot(Hero hero)
    {
        Scanner s = new Scanner(System.in);
        System.out.println("What type of potion would you like to use?\n1. Full Heal\n2. Half Heal\n3. Phoenix Down");
        int choice = s.nextInt();
        if (choice == 1){
            for (int i = potions.size() - 1; i > 0; i--){
                if (potions.get(i).getType().equals("1")){
                    int heal = hero.getInitialHP() - hero.getHP();
                    hp += heal;
                    potions.remove(potions.size() - 1);
                    System.out.println(heal + " HP healed, " + getPotionCount() + " potions remaining");
                }
            }
        } else if (choice == 2){
            for (int i = potions.size() - 1; i > 0; i--){
                if (potions.get(i).getType().equals("2")){
                    int heal = (hero.getInitialHP() - hero.getHP()) / 2;
                    hp += heal;
                    potions.remove(hero.getInitialHP() - (hero.getHP()/2));
                    System.out.println(heal + " HP healed, " + getPotionCount() + " potions remaining");
                }
            }
        } else if (choice == 3){
            for (int i = potions.size() - 1; i > 0; i--){
                if (potions.get(i).getType().equals("3")){
                    revives++;
                }
            }
        } else {
            System.out.println("No potions of the requested type.");
        }
    }
    public int getRevives()
    {
        return revives;
    }
    public void useBomb()
    {
        bombs.remove(bombs.size() - 1);
        System.out.println("Bomb used, " + getBombCount() + " bombs remaining");
    }
    public void setWeapon(Weapon weapon)
    {
        this.weapon.remove(this.weapon.get(0));
        this.weapon.add(weapon);
    }   
    public void setArmor(Armor armor)
    {
        this.armor.remove(this.armor.get(0));
        this.armor.add(armor);
    }
    public Armor getArmor()
    {
        return armor.get(0);
    }
    public Weapon getWeapon()
    {
        return weapon.get(0);
    }
    public int getDirection()
    {
        return direction;
    }
    public void addPotion(Potion p) 
    {
        potions.add(p);
    }
    public void addBomb(Bomb b) 
    {
        bombs.add(b);
    }
    public void incrementMoney(int n)
    {
        money += n;
    }
    public int getMoney()
    {
        return money;
    }
    public void setMoney(int money)
    {
        this.money = money;
    }
    public int getPotionCount() 
    {
        return potions.size();
    }
    public int getBombCount() 
    {
        if (bombs.size() > 0){
            return bombs.size();
        }
        return 0;
    }
    public List<Monster> move(char direction, List<Monster> m, List<Boss> v, List<Potion> p, List<TownsPerson> t, String[][] map, int monstersKilled)
    {
        switch (direction){
            case 'w':
                if (y != 0){
                    y--;
                }
                direction = 1;
                break;
            case 'a':
                if (x != 0){
                    x--;
                }
                direction = 2;
                break;
            case 's':
                if (y != 14){
                    y++;
                }
                direction = 3;
                break;
            case 'd':
                if (x != 14){
                    x++;
                }
                direction = 4;
                break;
            case 'p':
                if (potions.size() > 0){
                    usePot(this);
                }else {
                    System.out.println("No potions available.");
                }
            default:
                System.out.println("Please use w, a, s, or d to move.");
        }
        if (random.nextInt(1, 101) <= 10){
            int m_x = this.getX();
            int m_y = this.getY();
            int atk = 0;
            int speed = 0;
            Scanner input = new Scanner(System.in);
            if ((this.getWeapon().getDamage() < 25) || (this.getArmor().getAbsorption() > 0.75)){
                atk = (int) ((Math.random() * (15 - 1)) + 1);
                speed = (int) ((Math.random() * (1 - 0)) + 0);
            }else {
                atk = (int) ((Math.random() * (30 - 15)) + 1);
                speed = (int) ((Math.random() * (3 - 1)) + 1);
            }
            int health = (int) ((Math.random() * (100 - 1)) + 1);
            int direction_m = (int) ((Math.random() * (4 - 1)) + 1);
            int money = (int) ((Math.random() * (4 - 1)) + 1);
            m.add(new Monster(m_x, m_y, this, atk, speed, health, direction_m, money));
            map[m.get(m.size()).getY()][m.get(m.size()).getX()] = "M";
            if(m.get(m.size()).fight(input, this) == 1){
                map[m.get(m.size()).getY()][m.get(m.size()).getX()] = "*";
                m.remove(m.get(m.size()));
                monstersKilled++;
            }
        }
        return m;
    }
    public void damage(double dmg)
    {
        if (dmg > 0){
            int newHealth = hp -= dmg * armor.get(0).getAbsorption();
            if (newHealth > 0){
                hp = newHealth;
                System.out.println("You have taken " + dmg + " damage!");
                System.out.println(hp + " health remaining.");
            }else {
                if (revives > 0){
                    hp = initialHP;
                    System.out.println("Hero was saved from death by a revive!");
                }else {
                    hp -= getHP();
                    System.out.println("0 health remaining.");
                }
            }
        }else {
            System.out.println("You did not take any damage this turn.");
        }
    }
}
