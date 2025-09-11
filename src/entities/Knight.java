package Entities;

import java.util.ArrayList;
import java.util.List;

import Charms.Charms;
import Items.Inventory;
import Shield.Shields;
import weapons.Weapons;

public class Knight extends Entity {
    public Inventory inventory;
    private Shields shield;
    private Charms charm;

    // Constructor
    public Knight(String name, int health, int defense, Weapons weapon, String type, int maxHealth, int gold, int level, int experience, Inventory inventory, Shields shield, Charms charm) {
        super(name, health, defense, weapon, type, maxHealth, gold, level, experience, charm);
        this.weapon = weapon;
        this.inventory = inventory;
        this.shield = shield;
    }

    public List<String> getAllUniqueItem(String item_name){
        List<String> onlyItems = new ArrayList<>();
        this.getInventory().getItems().forEach((itemName, itemQuantity) -> {
            String[] itemToSearchName = itemName.split(" ");
            if (itemToSearchName.length > 1 && (itemToSearchName[1].equals(item_name))){
                onlyItems.add(itemName);
            }
        });
        return onlyItems;
    }



    public String getAllWeaponsAndShieldAndCharm(){
        java.util.List<String> onlySwordAndShields = new java.util.ArrayList<>();
        this.getInventory().getItems().forEach((itemName, itemQuantity) -> {
            String[] partsName = itemName.split(" ");
            if (partsName.length > 1 && (partsName[1].equals("Sword") || partsName[1].equals("Shield") || partsName[1].equals("Charms"))) {
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
    public Charms getCharm() {
        return charm;
    }
    public void setCharm(Charms charm) {
        this.charm = charm;
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
        this.defense = (int)(((this.defense * this.level) + shield.getDefense()) * (this.charm != null ? this.charm.getDef_bonus().floatValue() : 1));
    }


    // Functions


    public String toString() {
    return  "=== Knight Stats ===\n" +
            "Name      : " + name + "\n" +
            "Health    : " + health + "\n" +
            "Defense   : " + defense + "\n" +
            "Level     : " + level + "\n" +
            "XP        : " + experience + "\n" +
            "Gold      : " + gold + "\n" +
            "Weapon    : " + (weapon != null ? weapon.getName() : "None") + "\n" +
            "Charm     : " + (charm != null ? charm.getName() : "No charm equipped") + "\n" +
            "Shield    : " + (shield != null ? shield.getName() : "None") + "\n" +
            "====================\n";
    }

}