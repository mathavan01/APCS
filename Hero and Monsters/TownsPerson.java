import java.util.*;
public class TownsPerson
{
    private int x;
    private int y;
    private int story;
    public TownsPerson(int x, int y)
    {
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
    public void setStory(int x)
    {
        story = x;
    }
    public int getStory()
    {
        return story;
    }
    public String diologue(int diologue, int monstersKilled, Hero hero, List<Boss> b, List<TownsPerson> t, Scanner s)
    {
        System.out.println("Villager: \"Hello!\"");
        switch (diologue){
            case 0:
                if (monstersKilled < 5){
                    System.out.println("My sheep have been taken… My family is gone and I have nothing left except for bronze amor I have buried… Only a true hero will receive this.");
                    System.out.println("(Kill 5 monsters)");
                }else {
                    System.out.println("Good Job! Take my armor.");
                    Armor newArmor = new Armor(0.66, "Iron Armor");
                    hero.setArmor(newArmor);
                }
                break;
            case 1:
                if (monstersKilled < 10){
                    System.out.println("My sheep have been taken… My family is gone and I have nothing left except for a broadsword I have buried… Only the best will receive this.");
                    System.out.println("(Kill 10 monsters)");
                }else {
                    System.out.println("Good Job! Take my weapon.");
                    Weapon newWeapon = new Weapon((int) ((Math.random() * (50 - 20)) + 20), "Greatsword", 10, 1.75);
                    hero.setWeapon(newWeapon);
                }
                break;
            case 3:
                if (b.size() > 0){
                    for (Boss i : b){
                        System.out.println("Next Boss Coordinates: " + "\nX: " + (i.getX() + 1) + "\nY: " + (15 - i.getY()));
                    }
                }
                break;
            case 4:
                for (TownsPerson i : t){
                    System.out.println("Villager Coordinates: " + "\nX: " + (i.getX() + 1) + "\nY: " + (15 - i.getY()));
                }
                break;
            default:
                if (monstersKilled > 0){
                    System.out.println("Welcome to my shop. Here are the items available for purchase.");
                    System.out.println("Item:\tCost:");
                    System.out.println("1. Satchel (adds 7 more sotrage slots)\t10");
                    System.out.println("2. Sandals (2x attack speed)\t15");
                    System.out.println("3. Short Sword\t20");
                    System.out.println("4. Long Sword\t25");
                    System.out.println("5. Battle Axe\t30");
                    int choice = s.nextInt();               
                    switch (choice){
                        case 1:
                            if (hero.getMoney() > 10){
                                hero.setMoney(hero.getMoney() - 10);
                                hero.setStorageSpace(9);
                            }
                            break;                  
                        case 2:
                             if (hero.getMoney() > 15){
                                 hero.setMoney(hero.getMoney() - 15);
                                hero.getArmorList().add(new Armor(1, "Sandals"));
                            }
                            break;
                        case 3:
                             if (hero.getMoney() > 20){
                                hero.setMoney(hero.getMoney() - 20);
                                hero.setWeapon(new Weapon(50, "Short Sword", 20, 2));
                            }
                            break;
                        case 4:
                             if (hero.getMoney() > 25){
                                hero.setMoney(hero.getMoney() - 25);
                                hero.setWeapon(new Weapon(75, "Long Sword", 30, 2.5));
                            }
                            break;
                        case 5:
                             if (hero.getMoney() > 30){
                                hero.setMoney(hero.getMoney() - 30);
                                hero.setWeapon(new Weapon(100, "Battle Axe", 45, 3));
                            }
                            break;
                        default:
                            break;
                    }
                }
                break;
        }
        return "";
    }
}
