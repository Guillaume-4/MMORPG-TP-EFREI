package Charms;

import Items.Item;
import weapons.EnumRarity;

public class Charms extends Item {
    private Float atq_bonus;
    private Float def_bonus;

    public Charms(String charms_name, Integer charms_price, EnumRarity rarity, Float atq_bonus, Float def_bonus){
        super(charms_name, charms_price);
        this.atq_bonus = (atq_bonus/100) + 1;
        this.def_bonus = (def_bonus/100) + 1;
    }

    public Float getAtq_bonus() {
        return atq_bonus;
    }
    public Float getDef_bonus() {
        return def_bonus;
    }


    public static Charms getCharm(String name) {
        switch (name) {
            case "Wooden Shield":
                return new Charms("Attack Charms", 50, EnumRarity.RARE, 20f, 0f);
            case "Iron Shield":
                return new Charms("Defense Charms", 50, EnumRarity.RARE, 0f, 20f);
            case "Steel Shield":
                return new Charms("Legendary Charms", 150, EnumRarity.LEGENDARY, 40f, 40f);
            default:
                return null;
        }
    }
}
