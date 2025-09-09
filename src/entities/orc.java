package entities;

import weapons.Weapons;

public class orc extends entity {

    public orc(String name, int health, int defense, Weapons weapon, String type) {
        super(name, health, defense, weapon, type);
        this.gold = 20;
    }
    
}
