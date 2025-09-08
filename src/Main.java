public class Main {
    public static void main(String[] args) {
        Weapons sword = new Weapons("Excalibur", 15, 10, 5);
        Weapons stick = new Weapons("Bâton", 1, 5, 3);

        Knight knight = new Knight("Arthur", 100, 5, 0, sword);
        Knight enemy = new Knight("Goblin", 50, 2, 0, stick);

        Item potion = new Item("Health Potion", 10);
        Item shield = new Item("Wooden Shield", 15);

        knight.fight(knight, enemy);
        enemy.setHealth(50);

        knight.fight(knight, enemy);

        Shop shop = new Shop();
        shop.AddItem(potion);
        shop.AddItem(shield);
        shop.displayItem();

        System.out.println(knight.toString());
    }
}
