package entities;

public class goblin extends entity {

    public goblin(String name, int health, int defense, weapons.Weapons weapon) {
        super(name, health, defense, weapon);
        this.gold = 10;
    }
    
}
