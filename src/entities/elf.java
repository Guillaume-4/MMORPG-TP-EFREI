package Entities;

public class Elf extends Entity {

    public Elf(String name, int health, int defense, weapons.Weapons weapon, String type) {
        super(name, health, defense, weapon, type, health, 30, 1, 0, null);
    }

    public String toString() {
        return  "=== Monster Encountered ===\n" +
                "Type      : Elf\n" +
                "Name      : " + getName() + "\n" +
                "Health    : " + getHealth() + "\n" +
                "Defense   : " + getDefense() + "\n" +
                "Weapon    : " + (getWeapon() != null ? getWeapon().getName() : "Claws & Teeth") + "\n" +
                "Gold Drop : " + getGold() + "\n" +
                "===========================";
    }
}
