package entities;

import weapons.Weapons;

public class orc extends entity {

    public orc(String name, int health, int defense, Weapons weapon) {
        super(name, health, defense, weapon);
        this.gold = 20;
    }
    
}
