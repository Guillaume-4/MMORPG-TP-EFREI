package entities;

import weapons.Weapons;

public class Knight extends entity {

    // Constructor
    public Knight(String name, int health, int defense, Weapons weapon) {
        super(name, health, defense,weapon);
        this.level = 1;
        this.experience = 0;
        this.weapon = weapon;
    }

    // Functions


    public String toString() {
        return this.name + "{" +
                "\nname='" + name + '\'' +
                ", \nhealth=" + health +
                ", \ndefense=" + defense +
                ", \nlevel=" + level +
                ", \nexperience=" + experience +
                ", \ngold=" + gold +
                ", \nweapon=" + weapon.getName() + "\n" +
                '}';
    } 

}