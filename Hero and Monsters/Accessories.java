public abstract class Accessories
{
    public boolean hasAccessory(Hero h, String name)
    {
        for (Weapon i: h.getWeaponList()){
            if (i.getName().equals(name)){
                return true;
            }
        }
        for (Armor i: h.getArmorList()){
            if (i.getName().equals(name)){
                return true;
            }
        }
        for (Potion i: h.getPotionList()){
            if (i.getType().equals(name)){
                return true;
            }
        }
        return false;
    }
}
