package Entities;

import Weapons.Weapons;

public class Orc extends Entity {

    public Orc(String name, int health, int defense, Weapons weapon, String type) {
        super(name, health, defense, weapon, type, health, 20, 1, 0, null);
    }

    public String toString() {
        return  "=== Monster Encountered ===\n" +
                "Type      : Orc\n" +
                "Name      : " + getName() + "\n" +
                "Health    : " + getHealth() + "\n" +
                "Defense   : " + getDefense() + "\n" +
                "Weapon    : " + (getWeapon() != null ? getWeapon().getName() : "Claws & Teeth") + "\n" +
                "Gold Drop : " + getGold() + "\n" +
                "===========================";
    }
}