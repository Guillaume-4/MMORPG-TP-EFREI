package entities;

public class elf extends entity {

    public elf(String name, int health, int defense, weapons.Weapons weapon, String type) {
        super(name, health, defense, weapon, type);
        this.gold = 30;
    }

}
