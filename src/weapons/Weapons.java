package weapons;

import Items.Item;
import Shield.Shields;

public class Weapons extends Item {

    private String name;
    private int damage;
    private EnumRarity rarity;
    
    // Constructor

    public Weapons(String name, int damage,int price, EnumRarity rarity) {
        super(name, price);
        this.name = name;
        this.damage = damage;
        this.rarity = rarity;
    }

    public static Weapons getWeapons(String name) {
        switch (name) {
            case "Stone Sword":
                return new Weapons("Stone Sword", 5, 15, EnumRarity.COMMON);
            case "Iron Sword":
                return new Weapons("Iron Sword", 10, 25, EnumRarity.UNCOMMON);
            case "Steel Sword":
                return new Weapons("Steel Sword", 15, 35, EnumRarity.RARE);
            case "Dragon Sword":
                return new Weapons("Dragon Sword", 20, 50, EnumRarity.LEGENDARY);
            default:
                return null;
        }
    }
    
    // Getters and Setters

    public String getName() {
        return name;
}
    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setName(String name) {
        this.name = name;
    }
    public EnumRarity getRarity() {
        return rarity;
    }


}