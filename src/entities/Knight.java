package Entities;

import java.util.ArrayList;
import java.util.List;

import Items.Inventory;
import Shield.Shields;
import weapons.Weapons;

public class Knight extends Entity {
    public Inventory inventory;
    public Shields shield;

    // Constructor
    public Knight(String name, int health, int defense, Weapons weapon, String type, int maxHealth, int gold, int level, int experience, Inventory inventory, Shields shield) {
        super(name, health, defense, weapon, type, maxHealth, gold, level, experience);
        this.weapon = weapon;
        this.inventory = inventory;
        this.shield = shield;
    }

    public List<String> getAllSword(){
        List<String> onlySword = new ArrayList<>();
        this.getInventory().getItems().forEach((itemName, itemQuantity) -> {
            String[] swordName = itemName.split(" ");
            if (swordName.length > 1 && (swordName[1].equals("Sword"))){
                onlySword.add(itemName);
            }
        });
        return onlySword;
    }

    public List<String> getAllShield(){
        List<String> onlyShield = new ArrayList<>();
        this.getInventory().getItems().forEach((itemName, itemQuantity) -> {
            String[] shieldName = itemName.split(" ");
            if (shieldName.length > 1 && (shieldName[1].equals("Shield"))){
                onlyShield.add(itemName);
            }
        });
        return onlyShield;
    }

    public String getAllWeaponsAndShield(){
        java.util.List<String> onlySwordAndShields = new java.util.ArrayList<>();
        this.getInventory().getItems().forEach((itemName, itemQuantity) -> {
            String[] partsName = itemName.split(" ");
            if (partsName.length > 1 && (partsName[1].equals("Sword") || partsName[1].equals("Shield"))) {
                onlySwordAndShields.add(itemName);
            }
        });
        return String.join(", ", onlySwordAndShields);
    }

    // Getters and Setters
    public void setExperience(int experience) {
        this.experience = experience;
    }
    public int getExperience() {
        return experience;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getLevel() {
        return level;
    }

    public Weapons getWeapon() {
        return super.getWeapon();
    }

    public Inventory getInventory() {
        return inventory;
    }
    
    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Shields getShield() {
        return shield;
    }
    public void setShield(Shields shield) {
        this.shield = shield;
        this.defense = shield.getDefense();
    }


    // Functions


    public String toString() {
        return "{" +
                "\nname='" + name + '\'' +
                ", \nhealth=" + health +
                ", \ndefense=" + defense +
                ", \nlevel=" + level +
                ", \nexperience=" + experience +
                ", \ngold=" + gold +
                ", \nweapon=" + weapon.getName() +
                ", \nshield=" + shield.getName() + "\n" +
                "}\n";

    }

}