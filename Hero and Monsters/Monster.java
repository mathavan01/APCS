import java.util.*;
public class Monster
{
    private int atk;
    private int health;
    private int speed;
    private int direction;
    private int money;
    private int x;
    private int y;
    SplittableRandom random = new SplittableRandom();
    public Monster(int x, int y, Hero hero, int atk, int speed, int health, int direction, int money)
    {
        this.x = x;
        this.y = y;
        this.atk = atk;
        this.speed = speed;
        this.health = health;
        this.direction = direction;
        this.money = money;

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
    public int fight(Scanner scaner, Hero hero)
    {
        String choice = scaner.nextLine();
        System.out.println("Monster encountered! What would you like to do?");
        System.out.println("Stats: " + atk + " Attack, " + speed + " Speed, " + health + " Health");
        while (health > 0 && hero.getHP() > 0){
            System.out.println("1. Attack\n2. Run\n3. Potion\n4. Bomb");
            int trueDamage = (int) ((Math.random() * (atk - (atk - 10))) + (atk - 10));
            choice = scaner.nextLine();
            switch (choice){
                case "1":
                    System.out.println("Battle Commences!");
                    if (trueDamage > hero.getHP()){
                        hero.damage(hero.getHP());
                        System.out.println("* Hero collapses and is struck a deadly blow by Monster * \n** Monsters in the surrounding area converge on the carcass. **");
                        return 3;
                    }else {
                        hero.damage(trueDamage);
                    }
                    if (hero.getHP() >0){
                        if (damage(hero.getWeapon().getDamage(), hero)){
                            return 1;
                        }
                    }
                    break;
                case "2":
                    if (speed == 0){
                        if (direction != hero.getDirection()){                           
                            System.out.println("Hero got away safely!");                            
                            return 2;                            
                        } else {
                            if (random.nextInt(1, 101) <= 75){
                                System.out.println("Hero got away safely!");                            
                                return 2;
                            }
                        }
                    }
                    if (speed == 1){
                        if (direction != hero.getDirection()){                            
                            System.out.println("Hero got away safely!");                            
                            return 2;
                        } else {
                            if (random.nextInt(1, 101) <= 50){
                                System.out.println("Hero got away safely!");                            
                                return 2;
                            }
                        }
                    }
                    if (speed == 2){
                        if (direction != hero.getDirection()){
                            if (random.nextInt(1, 101) <= 75){
                                System.out.println("Hero got away safely!");                            
                                return 2;
                            }
                        } else {
                            if (random.nextInt(1, 101) <= 25){
                                System.out.println("Hero got away safely!");                            
                                return 2;
                            }
                        }
                    }
                    System.out.println("Hero could not escape safely.");
                    if (trueDamage > hero.getHP()){
                        hero.damage(hero.getHP());
                        System.out.println("* Hero collapses and is struck a deadly blow by Monster * \n** Monsters in the surrounding area converge on the carcass. **");
                        return 3;
                    }else {
                        hero.damage(trueDamage);
                    }
                    break;
                case "3":
                    hero.usePot(hero);
                    break;
                case "4":
                    if (hero.getBombCount() > 0){
                        damage(1000, hero);
                        hero.useBomb();
                        break;
                    }else{
                        System.out.println("No bombs available.");
                        break;
                    }
                default:
                    System.out.println("Please select one of the available options.");
            }
        }
        return 0;
    }
    public boolean damage(int dmg, Hero hero)
    {
        int prob = (int) ((Math.random() * (4 - 1)) + 1);
        int initialdmg = dmg;
        if (random.nextInt(1, 101) <= hero.getWeapon().getCRate()){
            dmg *= hero.getWeapon().getCDmg();   
        }
        if (speed == 0){
            if (hero.hasAccessory(hero, "Sandals")){               
                health -= dmg;
                if (dmg > initialdmg){
                    System.out.println("Crit Hit!");
                }
                if (health <= 0){
                    System.out.println("You dealt " + dmg + " damage!");
                    System.out.println("Monster Defeated!");
                    System.out.println("You earned " + money + " coins.");
                    hero.incrementMoney(money);
                    return true;
                }else{        
                    System.out.println("You dealt " + dmg + " damage!");
                    System.out.println("Monster has " + health + " health remaining.");
                }                 
            } else if (random.nextInt(1, 101) <= 75){
                health -= dmg;
                if (dmg > initialdmg){
                    System.out.println("Crit Hit!");
                }
                if (health <= 0){
                    System.out.println("You dealt " + dmg + " damage!");
                    System.out.println("Monster Defeated!");
                    System.out.println("You earned " + money + " coins.");
                    hero.incrementMoney(money);
                    return true;
                }else{        
                    System.out.println("You dealt " + dmg + " damage!");
                    System.out.println("Monster has " + health + " health remaining.");
                } 
            } else{
                System.out.println("Hero missed his attack.");
            }
        }
        if (speed == 1){
            if (hero.hasAccessory(hero, "Sandals")){               
                health -= dmg;
                if (dmg > initialdmg){
                    System.out.println("Crit Hit!");
                }
                if (health <= 0){
                    System.out.println("You dealt " + dmg + " damage!");
                    System.out.println("Monster Defeated!");
                    System.out.println("You earned " + money + " coins.");
                    hero.incrementMoney(money);
                    return true;
                }else{        
                    System.out.println("You dealt " + dmg + " damage!");
                    System.out.println("Monster has " + health + " health remaining.");
                }              
            } else if (random.nextInt(1, 101) <= 50){
                health -= dmg;
                if (dmg > initialdmg){
                    System.out.println("Crit Hit!");
                }
                if (health <= 0){
                    System.out.println("You dealt " + dmg + " damage!");
                    System.out.println("Monster Defeated!");
                    System.out.println("You earned " + money + " coins.");
                    hero.incrementMoney(money);
                    return true;
                }else{        
                    System.out.println("You dealt " + dmg + " damage!");
                    System.out.println("Monster has " + health + " health remaining.");
                } 
            } else{
                System.out.println("Hero missed his attack.");
            }
        }
        if (speed == 2){
            if (hero.hasAccessory(hero, "Sandals")){               
                if (random.nextInt(1, 101) <= 50){
                    health -= dmg;
                    if (dmg > initialdmg){
                        System.out.println("Crit Hit!");
                    }
                    if (health <= 0){
                        System.out.println("You dealt " + dmg + " damage!");
                        System.out.println("Monster Defeated!");
                        System.out.println("You earned " + money + " coins.");
                        hero.incrementMoney(money);
                        return true;
                    }else{        
                        System.out.println("You dealt " + dmg + " damage!");
                        System.out.println("Monster has " + health + " health remaining.");
                    } 
                } else{
                    System.out.println("Hero missed his attack.");
                }
            } else if (random.nextInt(1, 101) <= 25){
                health -= dmg;
                if (dmg > initialdmg){
                    System.out.println("Crit Hit!");
                }
                if (health <= 0){
                    System.out.println("You dealt " + dmg + " damage!");
                    System.out.println("Monster Defeated!");
                    System.out.println("You earned " + money + " coins.");
                    hero.incrementMoney(money);
                    return true;
                }else{        
                    System.out.println("You dealt " + dmg + " damage!");
                    System.out.println("Monster has " + health + " health remaining.");
                } 
            } else{
                System.out.println("Hero missed his attack.");
            }
        }
        if (speed == 3){
            System.out.println("Hero could not hit the monster.");
        }
        return false;
    }
}
