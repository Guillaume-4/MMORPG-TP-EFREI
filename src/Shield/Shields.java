package Shield;

import Items.Item;
import Weapons.EnumRarity;

public class Shields extends Item {
    private String name;
    private int defense;
    private EnumRarity rarity;

    // Constructor
    public Shields(String name, int defense, EnumRarity rarity, Integer price) {
        super(name, defense);
        this.name = name;
        this.defense = defense;
        this.rarity = rarity;
    }

    // Function

    public static Shields getShield(String name) {
        switch (name) {
            case "Wooden Shield":
                return new Shields("Wooden Shield", 5, EnumRarity.COMMON, 15);
            case "Iron Shield":
                return new Shields("Iron Shield", 10, EnumRarity.UNCOMMON, 25);
            case "Steel Shield":
                return new Shields("Steel Shield", 15, EnumRarity.RARE, 35);
            case "Dragon Shield":
                return new Shields("Dragon Shield", 20, EnumRarity.LEGENDARY, 50);
            default:
                return null;
        }
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public int getDefense() {
        return defense;
    }

    public EnumRarity getRarity() {
        return rarity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }


    public void setRarity(EnumRarity rarity) {
        this.rarity = rarity;
    }
}
