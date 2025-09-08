public class Knight{
    Weapons weapon;
    private String name;
    private int health;
    private int defense;
    private int level;
    private int experience;
    private int gold;
    private boolean isGuard;

    // Constructor
    public Knight(String name, int health, int defense, int gold, Weapons weapon) {
        this.name = name;
        this.health = health;
        this.defense = defense;
        this.level = 1;
        this.experience = 0;
        this.gold = gold;
        this.weapon = weapon;
    }

    // Functions

    public String fight(Knight enemy) {
        while(this.getHealth() > 0 && enemy.getHealth() > 0) {
            this.attack(enemy);
            if (enemy.getHealth() > 0) {
                enemy.attack(this);
            }
        }
        if (this.getHealth() > 0) {
            return this.getName() + " wins the battle!";
        } else {
            return enemy.getName() + " wins the battle!";
        }

    }

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

    public void levelUp() {
        this.level += 1;
        this.health += 10;
        this.defense += 2;
        this.experience = 0;
        System.out.println(this.name + " has leveled up to level " + this.level + "!");
    }

    public void gainExperience(int exp) {
        this.experience += exp;
        while (this.experience >= this.level * 100) {
            this.experience -= 100;
            this.levelUp();
        }
    }

    public void gainGold(int amount) {
        this.gold += amount;
        System.out.println(this.name + " has gained " + amount + " gold. Total gold: " + this.gold);
    }

    public void attack(Knight enemy) {
        if (this.weapon.getDurability() <= 0) {
            System.out.println(this.name + "'s weapon is broken and cannot be used to attack.");
            return;
        }
        int damageDealt = this.weapon.getDamage() - enemy.getDefense();
        if (damageDealt < 0) damageDealt = 0;
        if(enemy.isGuard) {
            damageDealt /= 2;
            System.out.println(enemy.getName() + " is guarding and takes half damage!");
        }
        enemy.setHealth(enemy.getHealth() - damageDealt);
        enemy.isGuard = false; 
        this.weapon.setDurability(this.weapon.getDurability() - 1);
        System.out.println(this.name + " attacks " + enemy.getName() + " with " + this.weapon.getName() + " for " + damageDealt + " damage.");
        if (enemy.getHealth() <= 0) {
            System.out.println(enemy.getName() + " has been defeated!");
            this.gainExperience(50);
            this.gainGold(20);
        }
    }


    // Getters and Setters
    public String getName() {
        return name;
    }
    public int getHealth() {
        return health;
    }
    public int getDefense() {
        return defense;
    }
    public int getLevel() {
        return level;
    }
    public int getExperience() {
        return experience;
    }
    public int getGold() {
        return gold;
    }
    public Weapons getWeapon() {
        return weapon;
    }
    public boolean getIsGuard() {
        return isGuard;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setIsGuard(boolean isGuard) {
        this.isGuard = isGuard;
    }
    public void setHealth(int health) {
        this.health = health;
    }
    public void setDefense(int defense) {
        this.defense = defense;
    }
    public void setLevel(int level) {
        this.level = level;
    }
    public void setExperience(int experience) {
        this.experience = experience;
    }
    public void setGold(int gold) {
        this.gold = gold;
    }
    public void setWeapon(Weapons weapon) {
        this.weapon = weapon;
    }


}