package Entities;

public class Goblin extends Entity {

    public Goblin(String name, int health, int defense, Weapons.Weapons weapon, String type) {
        super(name, health, defense, weapon, type, health, 10, 1, 0, null);
    }
    
    public String toString() {
        return  "=== Monster Encountered ===\n" +
                "Type      : Goblin\n" +
                "Name      : " + getName() + "\n" +
                "Health    : " + getHealth() + "\n" +
                "Defense   : " + getDefense() + "\n" +
                "Weapon    : " + (getWeapon() != null ? getWeapon().getName() : "Claws & Teeth") + "\n" +
                "Gold Drop : " + getGold() + "\n" +
                "===========================";
    }
}
