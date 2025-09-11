package App;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

import Entities.Entity;

import Entities.Elf;
import Entities.Goblin;
import Entities.Knight;
import Entities.Orc;
import Level.Level;
import Views.Page;
import weapons.EnumRarity;
import weapons.Weapons;
import Shop.Shop;
import Settings.Save;
import Shield.Shields;
import Settings.Config;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        ArrayList<Entity> listEnemyKnight = new ArrayList<Entity>();
        Page page = new Page();
        Save save = new Save();
        Level newLevel = new Level(1);

        page.resetConsole();

        // Initialise characters and weapons
        // Weapons for knight
        Weapons stone_sword = new Weapons("Stone Sword", 10, 10, EnumRarity.COMMON);
        Weapons iron_sword = new Weapons("Iron Sword", 20, 25, EnumRarity.UNCOMMON);
        Weapons steel_sword = new Weapons("Steel Sword", 30, 35, EnumRarity.RARE);
        Weapons dragon_sword = new Weapons("Dragon Sword", 40, 50, EnumRarity.LEGENDARY);

        // Weapons for enemies
        Weapons stick = new Weapons("Stick", 1, 10, EnumRarity.COMMON);
        Weapons axe = new Weapons("Axe", 10, 25, EnumRarity.UNCOMMON);
        Weapons bow = new Weapons("Bow", 8, 30, EnumRarity.RARE);

        // Shields
        Shields woodenShield = new Shields("Wooden Shield", 10, EnumRarity.COMMON, 10);
        Shields ironShield = new Shields("Iron Shield", 25, EnumRarity.UNCOMMON, 25);
        Shields steelShield = new Shields("Steel Shield", 35, EnumRarity.RARE, 35);
        Shields dragonShield = new Shields("Dragon Shield", 50, EnumRarity.LEGENDARY, 50);



        Knight knight = new Knight("Arthur", 100, 5, stone_sword, "knight", 100, 0, 1, 0, new Items.Inventory(), woodenShield);
        Goblin goblin = new Goblin("Goblin", 50, 2, stick, "goblin");
        Orc orc = new Orc("Orc", 80, 3, axe, "orc");
        Elf elf = new Elf("Elf", 60, 4, bow, "elf");

        listEnemyKnight.add(goblin);
        listEnemyKnight.add(orc);
        listEnemyKnight.add(elf);
        

        // Initialise shop and add items


        Shop shop = new Shop();
        shop.AddItem(ironShield);
        shop.AddItem(steelShield);
        shop.AddItem(dragonShield);
        shop.AddItem(iron_sword);
        shop.AddItem(steel_sword);
        shop.AddItem(dragon_sword);



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

                save.saveGame(knight, shop, newLevel);
                page.resetConsole();
                page.setActualPage("Home");

            }else if(!value && key.equals("first_character")){

                if(saveData.get("character") != null){
                    knight.setName(saveData.get("character"));
                    knight.setHealth(save.getIntOrDefault(saveData, "health", 100));
                    knight.setLevel(save.getIntOrDefault(saveData, "level", 1));
                    knight.setExperience(save.getIntOrDefault(saveData, "experience", 0));
                    knight.setMaxHealth(knight.getHealth());
                    knight.setInventory(save.getInventoryFromString(saveData.get("inventory")));
                    knight.setShield(Shields.getShield(saveData.get("shield_name")));
                    knight.setWeapon(new Weapons(
                        saveData.get("weaponName"),
                        save.getIntOrDefault(saveData, "weaponDamage", 0),
                        save.getIntOrDefault(saveData, "weaponDurability", 0),
                        EnumRarity.valueOf(saveData.get("weaponRarity"))
                    ));
                    knight.setGold(save.getIntOrDefault(saveData, "gold", 0));

                    shop.setItemsFromSave(saveData.get("shop_items"));

                    newLevel.setLevelNumber(save.getIntOrDefault(saveData, "level_number", 0));
                    newLevel.setRewardGold(save.getIntOrDefault(saveData, "level_gold_reward", 20));

                    System.out.println("Welcome back " + knight.getName() + "!");

                }
                page.setActualPage("Home");
            }
        });
        

        while (page.getActualPage() != "Exit") {
            System.out.println(page.jumpToPage(shop));
            String choice = scanner.nextLine();
            Entity enemyName = (Entity) listEnemyKnight.get((int)(Math.random() * listEnemyKnight.size()));
            page.goToPage(choice, shop, knight, enemyName, newLevel);
            save.saveGame(knight, shop, newLevel);
        }

        scanner.close();
    }
}
