package Entities;

import weapons.Weapons;

public class Knight extends Entity {

    // Constructor
    public Knight(String name, int health, int defense, Weapons weapon, String type, int maxHealth, int gold, int level, int experience) {
        super(name, health, defense, weapon, type, maxHealth, gold, level, experience);
        this.weapon = weapon;
    }

    // Getters and Setters
    public void setExperience(int experience) {
        this.experience = experience;
    }
    public int getExperience() {
        return experience;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public int getLevel() {
        return level;
    }

    public Weapons getWeapon() {
        return super.getWeapon();
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