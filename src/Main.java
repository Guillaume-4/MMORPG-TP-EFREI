import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList listEnemyKnight = new ArrayList<Knight>();
        Page page = new Page();

        Weapons sword = new Weapons("Excalibur", 15, 50, 5);
        Weapons stick = new Weapons("Stick", 1, 5, 3);
        Weapons axe = new Weapons("Axe", 10, 4, 7);
        Weapons bow = new Weapons("Bow", 8, 10, 4);

        Knight knight = new Knight("Arthur", 100, 5, 0, sword);
        Knight goblin = new Knight("Goblin", 50, 2, 0, stick);
        Knight orc = new Knight("Orc", 80, 3, 0, axe);
        Knight elf = new Knight("Elf", 60, 4, 0, bow);

        listEnemyKnight.add(goblin);
        listEnemyKnight.add(orc);
        listEnemyKnight.add(elf);

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
    }
}
