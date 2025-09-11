package Entities;

import Charms.Charms;
import weapons.Weapons;

public class Entity {
    Weapons weapon;
    protected String name;
    protected int health;
    protected int defense;
    protected int gold;
    protected boolean isGuard;
    protected int level;
    protected int experience;
    private int maxHealth;
    protected String type;
    protected Charms charm;
    private int last_enemy_health;
    private int last_player_health;

    public Entity(String name, int health, int defense, Weapons weapon, String type, int maxHealth, int gold, int level, int experience, Charms charm) {
        this.name = name;
        this.health = health;
        this.defense = defense;
        this.weapon = weapon;
        this.maxHealth = maxHealth;
        this.gold = gold;
        this.level = level;
        this.experience = experience;
        this.isGuard = false;
        this.type = type;
        this.charm = charm;
    }
    

    public Integer attack(Entity enemy) {
        int damageDealt = (int)(this.weapon.getDamage() * (this.charm != null ? this.charm.getAtq_bonus().floatValue() : 1)) - enemy.getDefense();
        if (damageDealt < 0) damageDealt = 0;
        if(enemy.isGuard) {
            damageDealt /= 2;
            System.out.println(enemy.getName() + " is guarding and takes half damage!");
        }
        enemy.setHealth(enemy.getHealth() - damageDealt);
        enemy.isGuard = false; 
        
        System.out.println(this.name + " attacks " + enemy.getName() + " with " + this.weapon.getName() + " for " + damageDealt + " damage.");
        if (enemy.getHealth() <= 0) {
            System.out.println(enemy.getName() + " has been defeated!");
            if (this.type == "knight" ){
                this.gainExperience(50);
                this.gainGold(enemy.getGold());
            }
            
        }
        return enemy.getHealth();
    }

    public void gainExperience(int exp) {
        this.experience += exp;
        while (this.experience >= this.level * 100) {
            this.experience -= 100;
            this.levelUp();
        }
    }

    public void levelUp() {
        this.level += 1;
        this.health += 10;
        this.defense += 2;
        this.experience = 0;
        System.out.println(this.name + " has leveled up to level " + this.level + "!");
    }


    public void gainGold(int amount) {
        this.gold += amount;
        System.out.println(this.name + " has gained " + amount + " gold. Total gold: " + this.gold);
    }


    public void resetHP() {
        this.health = this.maxHealth;
    }

    public boolean fight(Entity enemy) {
        while(this.getHealth() > 0 && enemy.getHealth() > 0) {
            this.last_enemy_health = this.attack(enemy);
            if (enemy.getHealth() > 0) {
                this.last_player_health = enemy.attack(this);
                if(enemy.getHealth() - this.last_enemy_health == enemy.getHealth() && this.getHealth() - this.last_player_health == this.getHealth()){
                    System.out.println("Fight defeated because nobody lose health");
                    break;
                }
            }
        }
        return enemy.getHealth() > 0 ? false : true;

    }

    public int getMaxHealth() {
        return maxHealth;
    }
    public void setMaxHealth(int maxHealth) {
        this.maxHealth = maxHealth;
    }

    public int getDefense() {
        return defense;
    }

    public int getGold() {
        return gold;
    }
    public int getHealth() {
        return health;
    }
    public String getName() {
        return name;
    }
    public Weapons getWeapon() {
        return weapon;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
    public void setGold(int gold) {
        this.gold = gold;
    }
    public void setGuard(boolean isGuard) {
        this.isGuard = isGuard;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
    }
}
