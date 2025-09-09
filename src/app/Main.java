package app;
import java.util.ArrayList;
import java.util.Scanner;

import Entities.Entity;

import Entities.Elf;
import Entities.Goblin;
import Entities.Knight;
import Entities.Orc;
import Shop.Shop;
import items.Item;
import views.Page;
import weapons.Weapons;

public class Main {
    public static void main(String[] args) {
        ArrayList listEnemyKnight = new ArrayList<Knight>();
        Page page = new Page();

        // Initialise characters and weapons

        Weapons sword = new Weapons("Excalibur", 15, 5);
        Weapons stick = new Weapons("Stick", 1, 3);
        Weapons axe = new Weapons("Axe", 10, 7);
        Weapons bow = new Weapons("Bow", 8, 4);

        Knight knight = new Knight("Arthur", 100, 5, sword, "knight");
        Goblin goblin = new Goblin("Goblin", 50, 2, stick, "goblin");
        Orc orc = new Orc("Orc", 80, 3, axe, "orc");
        Elf elf = new Elf("Elf", 60, 4, bow, "elf");

        listEnemyKnight.add(goblin);
        listEnemyKnight.add(orc);
        listEnemyKnight.add(elf);



        // Initialise shop and add items

        Item potion = new Item("Health Potion", 10);
        Item shield = new Item("Wooden Shield", 15);

        Shop shop = new Shop();
        shop.AddItem(potion);
        shop.AddItem(shield);




        Scanner scanner = new Scanner(System.in);

        while (page.getActualPage() != "Exit") {
            System.out.println(page.jumpToPage(shop));
            String choice = scanner.nextLine();
            Entity enemyName = (Entity) listEnemyKnight.get((int)(Math.random() * listEnemyKnight.size()));
            page.goToPage(choice, shop, knight, enemyName);
        }

        scanner.close();
    }
}
