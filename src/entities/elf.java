package Entities;

public class Elf extends Entity {

    public Elf(String name, int health, int defense, weapons.Weapons weapon, String type) {
        super(name, health, defense, weapon, type);
        this.gold = 30;
    }

}
