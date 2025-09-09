package app;
import java.util.ArrayList;
import java.util.Scanner;

import entities.Knight;
import entities.elf;
import entities.goblin;
import entities.orc;
import items.Item;
import shop.Shop;
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

        Knight knight = new Knight("Arthur", 100, 5, sword);
        goblin goblin = new goblin("Goblin", 50, 2, stick);
        orc orc = new orc("Orc", 80, 3, axe);
        elf elf = new elf("Elf", 60, 4, bow);

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
            System.out.println(page.jumpToPage());
            String choice = scanner.nextLine();
            page.goToPage(choice, shop);
        }

        scanner.close();
    }
}
