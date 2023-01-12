import java.util.*;
public class Driver
{
    static final int winSideLength = 15;
    public static void main(String[] args)
    {
        int bossesKilled = 0;
        int monstersKilled = 0;
        boolean hasSatchel = false;
        Scanner input = new Scanner(System.in);
        List<Monster> monsterList = new ArrayList<Monster>();
        List<Potion> potionList = new ArrayList<Potion>();
        List<TownsPerson> villagerList = new ArrayList<TownsPerson>();
        List<Boss> bossList = new ArrayList<Boss>();
        List<Bomb> bombList = new ArrayList<Bomb>();
        String map[][] = new String[winSideLength][winSideLength];
        Hero hero = new Hero();
        map[hero.getY()][hero.getX()] = "@";
        for(int i = 0; i < winSideLength; i++){
            for(int j = 0; j < winSideLength; j++){
                map[i][j] = "*"; 
            }
        }
        int m_x, p_x, v_x, b_x;
        int m_y, p_y, v_y, b_y;
        int atk, speed, health, direction, money;
        for (int i = 0; i < 9; i++){
            p_x = (int) ((Math.random() * (winSideLength - 1)) + 1);
            p_y = (int) ((Math.random() * (winSideLength - 1)) + 1);
            String type = String.valueOf((int) ((Math.random() * (3 - 1)) + 1));
            potionList.add(new Potion(p_x, p_y, type));
            for (Potion a : potionList){
                    for (Monster b : monsterList){
                    if (p_x == a.getX() && p_y == a.getY()||p_x == b.getX() && p_y == b.getY()){
                        potionList.get(i).setX((int) ((Math.random() * (winSideLength - 1)) + 1));
                        potionList.get(i).setY((int) ((Math.random() * (winSideLength - 1)) + 1));
                    }
                }
            }
        }
        for (int i = 0; i < 5; i++){
            v_x = (int) ((Math.random() * (winSideLength - 1)) + 1);
            v_y = (int) ((Math.random() * (winSideLength - 1)) + 1);
            villagerList.add(new TownsPerson(v_x, v_y));
            for (Potion a : potionList){
                for (Monster b : monsterList){
                    for (TownsPerson c : villagerList){
                        if (v_x == a.getX() && v_y == a.getY()||v_x == b.getX() && v_y == b.getY()||v_x == c.getX() && v_y == c.getY()){
                            potionList.get(i).setX((int) ((Math.random() * (winSideLength - 1)) + 1));
                            potionList.get(i).setY((int) ((Math.random() * (winSideLength - 1)) + 1));
                        }
                    }
                }
            }
        }
        for (int i = 0; i < 5; i++){
            b_x = (int) ((Math.random() * (winSideLength - 1)) + 1);
            b_y = (int) ((Math.random() * (winSideLength - 1)) + 1);
            bombList.add(new Bomb(b_x, b_y));
            for (Potion a : potionList){
                for (Monster b : monsterList){
                    for (TownsPerson c : villagerList){
                        for (Boss d : bossList){
                            for (Bomb e: bombList){
                                d.setX((int) ((Math.random() * (winSideLength - 1)) + 1));
                                d.setY((int) ((Math.random() * (winSideLength - 1)) + 1));
                            }
                        }
                    }
                }
            }
        }
        for (int b = 0; b < 5; b++){
                villagerList.get(b).setStory(b);
        }
        System.out.println("** Hero & Monsters **\n* The map has been generated *\n* The enemies have been placed *\n* The items have been placed *");
        System.out.println("Hero begins his journey in the Southwest corner of Yore.");
        while (hero.getHP() > 0 && (monstersKilled < 30 || bossesKilled < 4 || potionList.size() != 0 || bombList.size() != 0)) {
            printMap(map);
            if (hero.getStorageSpace() > 2){
                hasSatchel = true;
            }
            System.out.println("\nArmor: " + hero.getArmor().getName() + "\nWeapon: " + hero.getWeapon().getName() + "\tDamage: " + hero.getWeapon().getDamage() + "\nPotions: " + hero.getPotionCount() + "\nBombs: " + hero.getBombCount() + "\nMoney: " + hero.getMoney() + "\nMonsters Killed: " + monstersKilled + "\nSandals?: " + hero.hasAccessory(hero, "Sandals") + "\nSatchel?: " + hasSatchel);
            System.out.println("Press w, a, s, or d to move, or p to use a potion");
            char move = input.next().charAt(0);
            map[hero.getY()][hero.getX()] = "*";
            if (hero.getHP() > 0){
                monsterList = hero.move(move, monsterList, bossList, potionList, villagerList, map, monstersKilled);
            }else {
                System.out.println("* Hero collapses and is struck a deadly blow by Monster * \n** Monsters in the surrounding area converge on the carcass. **");
            }
            map[hero.getY()][hero.getX()] = "@";
            for (int i = potionList.size() - 1; i >= 0; i--){
                if (hero.getX() == potionList.get(i).getX() - 1 && hero.getY() == potionList.get(i).getY() || hero.getX() == potionList.get(i).getX() + 1 && hero.getY() == potionList.get(i).getY() || hero.getX() == potionList.get(i).getX() && hero.getY() == potionList.get(i).getY() - 1 || hero.getX() == potionList.get(i).getX() && hero.getY() == potionList.get(i).getY() + 1){
                    map[potionList.get(i).getY()][potionList.get(i).getX()] = "P";
                    System.out.println("Hero finds a potion!");
                    hero.addPotion(potionList.get(i));
                    map[potionList.get(i).getY()][potionList.get(i).getX()] = "*";
                    potionList.remove(potionList.get(i));
                }
            }
            for (int i = bombList.size() - 1; i >= 0; i--){
                if (hero.getX() == bombList.get(i).getX() - 1 && hero.getY() == bombList.get(i).getY() || hero.getX() == bombList.get(i).getX() + 1 && hero.getY() == bombList.get(i).getY() || hero.getX() == bombList.get(i).getX() && hero.getY() == bombList.get(i).getY() - 1 || hero.getX() == bombList.get(i).getX() && hero.getY() == bombList.get(i).getY() + 1){
                    map[bombList.get(i).getY()][bombList.get(i).getX()] = "B";
                    System.out.println("Hero finds a bomb!");
                    hero.addBomb(bombList.get(i));
                    map[bombList.get(i).getY()][bombList.get(i).getX()] = "*";
                    bombList.remove(bombList.get(i));
                }
            }
            for (TownsPerson a : villagerList){
                if ((hero.getX() == a.getX() - 1 || hero.getX() == a.getX() - 2) && hero.getY() == a.getY() || (hero.getX() == a.getX() + 1 || hero.getX() == a.getX() + 2) && hero.getY() == a.getY() || hero.getX() == a.getX() && (hero.getY() == a.getY() + 1 || hero.getY() == a.getY() + 2) || hero.getX() == a.getX() && (hero.getY() == a.getY() - 1 || hero.getY() == a.getY() - 2)){
                    map[a.getY()][a.getX()] = "V";
                    Scanner s = new Scanner(System.in);
                    System.out.println(a.diologue(a.getStory(), monstersKilled, hero, bossList, villagerList, s));
                }
            }
            for (int i = monsterList.size() - 1; i >= 0; i--){
                if (hero.getX() == monsterList.get(i).getX() && hero.getY() == monsterList.get(i).getY()){
                    map[monsterList.get(i).getY()][monsterList.get(i).getX()] = "M";
                    if(monsterList.get(i).fight(input, hero) == 1){
                        map[monsterList.get(i).getY()][monsterList.get(i).getX()] = "*";
                        monsterList.remove(monsterList.get(i));
                        monstersKilled++;
                    }
                }
            }
            for (int i = bossList.size() - 1; i >= 0; i--){
                if (hero.getX() == bossList.get(i).getX() && hero.getY() == bossList.get(i).getY()){
                    System.out.println("BOSS ENCOUNTERED");
                    map[bossList.get(i).getY()][bossList.get(i).getX()] = "Z";
                    if(bossList.get(i).fight(input, hero) == 1){
                        map[bossList.get(i).getY()][bossList.get(i).getX()] = "*";
                        bossList.remove(bossList.get(i));
                        bossesKilled++;
                    }
                }
            }
            if ((monstersKilled > 5 && monstersKilled <= 10) && bossList.size() == 0 && hero.hasAccessory(hero, "1") && bossesKilled < 1){
                bossList.add(spawnBoss(1, hero));
                System.out.println("You feel a chill as a dangerous entity emerges...");
                for (Potion a : potionList){
                    for (Monster b : monsterList){
                        for (TownsPerson c : villagerList){
                            for (Boss d : bossList){
                                d.setX((int) ((Math.random() * (winSideLength - 1)) + 1));
                                d.setY((int) ((Math.random() * (winSideLength - 1)) + 1));
                            }
                        }
                    }
                }
            }
            if ((monstersKilled > 10 && monstersKilled <= 15) && bossList.size() == 0 && hero.hasAccessory(hero, "Short Sword") && bossesKilled < 2){
                bossList.add(spawnBoss(2, hero));
                System.out.println("the next boss has spawned...");
                for (Potion a : potionList){
                    for (Monster b : monsterList){
                        for (TownsPerson c : villagerList){
                            for (Boss d : bossList){
                                d.setX((int) ((Math.random() * (winSideLength - 1)) + 1));
                                d.setY((int) ((Math.random() * (winSideLength - 1)) + 1));
                            }
                        }
                    }
                }
            }
            if (monstersKilled > 15 && bossList.size() == 0 && hero.hasAccessory(hero, "Long Sword") && hero.hasAccessory(hero, "3") && bossesKilled < 3){
                bossList.add(spawnBoss(3, hero));
                System.out.println("The third boss has emerged...");
                for (Potion a : potionList){
                    for (Monster b : monsterList){
                        for (TownsPerson c : villagerList){
                            for (Boss d : bossList){
                                d.setX((int) ((Math.random() * (winSideLength - 1)) + 1));
                                d.setY((int) ((Math.random() * (winSideLength - 1)) + 1));
                            }
                        }
                    }
                }
            }
            if (monstersKilled > 25 && bossList.size() == 0 && hero.hasAccessory(hero, "Battle Axe") && hero.hasAccessory(hero, "3") && hero.hasAccessory(hero, "Iron Armor")){
                bossList.add(spawnBoss(4, hero));
                System.out.println("The final boss has emerged...");
                for (Potion a : potionList){
                    for (Monster b : monsterList){
                        for (TownsPerson c : villagerList){
                            for (Boss d : bossList){
                                d.setX((int) ((Math.random() * (winSideLength - 1)) + 1));
                                d.setY((int) ((Math.random() * (winSideLength - 1)) + 1));
                            }
                        }
                    }
                }
            }
        }
        if (hero.getHP() < 1){
            System.out.println("Game Over");
        }else {
            System.out.println("Congratulations, you finished the game!");
            System.out.println("A fairy rises out of the chest of the final monster.\nShe restores Hero’s memory which was lost after the wax melted from his wings\nas he foolishly tried to fly higher than the sun.\nThe fairy transports the Hero to the land in the clouds with his wings restored.\nThe End");
        }
    }
    public static void printMap(String map[][])
    {
        for (int n = 0 ; n < map.length ; n++){
            System.out.println(Arrays.toString(map[n]) + "\n"); 
        }
    }
    public static Boss spawnBoss(int difficulty, Hero hero)
    {
        int x = (int) ((Math.random() * (winSideLength - 0)) + 0);
        int y = (int) ((Math.random() * (winSideLength - 0)) + 0);
        int atk = 0;
        int speed = 0;
        int health = 0;
        int direction = (int) ((Math.random() * (4 - 1)) + 1);
        int money = 0;
        if (difficulty == 1){
            atk = 50;
            speed = 1;
            health = 200;
            money = 100;   
        }
        if (difficulty == 2){
            atk = 75;
            speed = 1;
            health = 350;
            money = 150;   
        }
        if (difficulty == 3){
            atk = 100;
            speed = 2;
            health = 500;
            money = 200;   
        }
        if (difficulty == 4){
            atk = 150;
            speed = 2;
            health = 1000;
            money = 400;   
        }
        Boss b = new Boss(x, y, atk, speed, health, direction, money, hero);
        return b;
    }
}