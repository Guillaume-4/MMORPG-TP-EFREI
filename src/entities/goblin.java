package Entities;

public class Goblin extends Entity {

    public Goblin(String name, int health, int defense, weapons.Weapons weapon, String type) {
        super(name, health, defense, weapon, type, health, 10, 1, 0);
    }
    
}
