package App;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Entities.Entity;

import Entities.Elf;
import Entities.Goblin;
import Entities.Knight;
import Entities.Orc;
import Items.Item;
import Views.Page;
import weapons.EnumWeaponRarity;
import weapons.Weapons;
import Shop.Shop;
import Settings.Save;
import Settings.Config;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Entity> listEnemyKnight = new ArrayList<Entity>();
        Page page = new Page();
        Save save = new Save();
        page.resetConsole();

        // Initialise characters and weapons

        Weapons sword = new Weapons("Stone Sword", 10, 5, EnumWeaponRarity.COMMON);
        Weapons stick = new Weapons("Stick", 1, 3, EnumWeaponRarity.COMMON);
        Weapons axe = new Weapons("Axe", 10, 7, EnumWeaponRarity.UNCOMMON);
        Weapons bow = new Weapons("Bow", 8, 4, EnumWeaponRarity.RARE);

        Knight knight = new Knight("Arthur", 100, 5, sword, "knight", 100, 0, 1, 0);
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


        // Tutorial page

        HashMap <String, Boolean> config = Config.loadConfig();
        HashMap <String, String> saveData = save.loadGame();
        config.forEach((key, value) -> {
            if (value && key.equals("tutorial")) {
                page.setActualPage("Tutorial");
                System.out.println("""
            === Prologue ===
            
            Tu ouvres les yeux dans une forêt obscure...
            Le vent froid glisse entre les arbres, 
            et une lueur étrange scintille au loin.
            
            Tu sens ton cœur battre plus vite.
            Une voix résonne dans ton esprit :
            
            "Héros... ton aventure commence ici"
            
            La voix s'estompe... mais le chemin devant toi s'éclaire.
            
            === Bonne chance, aventurier ! ===
            
            (Appuie sur une touche pour passer à la création de ton personnage)
            """ );
                scanner.nextLine();
                config.put("tutorial", false);
                Config.saveConfig(config);
                page.resetConsole();

            }
            
            if (value && key.equals("first_character")) {

                page.setActualPage("First_Character");
                System.out.println("Enter the name of your character:");
                String characterName = scanner.nextLine();
                knight.setName(characterName);
                System.out.println("Welcome " + knight.getName() + "!");
                config.put("first_character", false);
                Config.saveConfig(config);

                

                
                save.saveGame(knight);
                page.resetConsole();
                page.setActualPage("Home");

            }else if(!value && key.equals("first_character")){

                if(saveData.get("character") != null){
                    knight.setName(saveData.get("character"));
                    knight.setHealth(save.getIntOrDefault(saveData, "health", 100));
                    knight.setLevel(save.getIntOrDefault(saveData, "level", 1));
                    knight.setExperience(save.getIntOrDefault(saveData, "experience", 0));
                    knight.setWeapon(new Weapons(
                        saveData.get("weaponName"),
                        save.getIntOrDefault(saveData, "weaponDamage", 0),
                        save.getIntOrDefault(saveData, "weaponDurability", 0),
                        EnumWeaponRarity.valueOf(saveData.get("weaponRarity"))
                    ));

                    knight.setGold(save.getIntOrDefault(saveData, "gold", 0));
                    System.out.println("Welcome back " + knight.getName() + "!");

                }
                page.setActualPage("Home");
            }
        });

        

        while (page.getActualPage() != "Exit") {
            System.out.println(page.jumpToPage(shop));
            String choice = scanner.nextLine();
            Entity enemyName = (Entity) listEnemyKnight.get((int)(Math.random() * listEnemyKnight.size()));
            page.goToPage(choice, shop, knight, enemyName);
        }

        scanner.close();
    }
}
