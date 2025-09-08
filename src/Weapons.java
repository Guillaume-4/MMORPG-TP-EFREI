public class Weapons {

    String name;
    int damage;
    int durability;
    int weight;
    
    // Constructor

    public Weapons(String name, int damage, int durability, int weight) {
        this.name = name;
        this.damage = damage;
        this.durability = durability;
        this.weight = weight;
    }
    
    // Getters and Setters

    public String getName() {
        return name;
    }
    public int getDamage() {
        return damage;
    }
    public int getDurability() {
        return durability;
    }
    public int getWeight() {
        return weight;
    }
    public void setDurability(int durability) {
        this.durability = durability;
    }
    public void setDamage(int damage) {
        this.damage = damage;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public void setName(String name) {
        this.name = name;
    }


}