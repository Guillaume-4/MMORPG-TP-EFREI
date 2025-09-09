package Entities;

import weapons.Weapons;

public class Orc extends Entity {

    public Orc(String name, int health, int defense, Weapons weapon, String type) {
        super(name, health, defense, weapon, type);
        this.gold = 20;
    }
    
}
