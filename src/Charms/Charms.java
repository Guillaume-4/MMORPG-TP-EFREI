package Charms;

import Items.Item;
import Weapons.EnumRarity;

public class Charms extends Item {
    private Integer atq_bonus;
    private Integer def_bonus;

    public Charms(String charms_name, Integer charms_price, EnumRarity rarity, Integer atq_bonus, Integer def_bonus){
        super(charms_name, charms_price);
        this.atq_bonus = atq_bonus;
        this.def_bonus = def_bonus;
    }

    public Integer getAtq_bonus() {
        return atq_bonus;
    }
    public Integer getDef_bonus() {
        return def_bonus;
    }


    public static Charms getCharm(String name) {
        switch (name) {
            case "Attack Charms":
                return new Charms("Attack Charms", 50, EnumRarity.RARE, 2, 0);
            case "Defense Charms":
                return new Charms("Defense Charms", 50, EnumRarity.RARE, 0, 2);
            case "Legendary Charms":
                return new Charms("Legendary Charms", 150, EnumRarity.LEGENDARY, 4, 4);
            default:
                return null;
        }
    }
}
