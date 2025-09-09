package entities;

public class elf extends entity {

    public elf(String name, int health, int defense, weapons.Weapons weapon) {
        super(name, health, defense, weapon);
        this.gold = 30;
    }

}
