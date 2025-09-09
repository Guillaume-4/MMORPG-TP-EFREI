package weapons;
public class Weapons {

    private String name;
    private int damage;
    private int weight;
    
    // Constructor

    public Weapons(String name, int damage,int weight) {
        this.name = name;
        this.damage = damage;
        this.weight = weight;
    }
    
    // Getters and Setters

    public String getName() {
        return name;
    }
    public int getDamage() {
        return damage;
    }

    public int getWeight() {
        return weight;
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