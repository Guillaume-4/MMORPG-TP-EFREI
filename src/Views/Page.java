package Views;
import java.util.List;
import java.util.Scanner;

import Charms.Charms;
import Entities.Entity;
import Entities.Knight;
import Items.Item;
import Level.Level;
import Shield.Shields;
import Shop.Shop;
import Weapons.Weapons;

public class Page {
    private String actualPage = "Home";
    Scanner scanner = new Scanner(System.in);


    public String jumpToPage(Shop shop, Knight knight){
        try {
            switch(actualPage){
                case "Home":
                    return Home();
                case "Shop":
                    return Shop(knight);
                case "Fight":
                    return Fight();
                default:
                    return "Invalid page";
            }
        } catch (Exception e) {
            return "Error : " + e.getMessage();
        }
        
    }


    // Methods to display pages

    public void goToPage(String choice, Shop shop, Knight knight, Entity enemy, Level newLevel){
        switch (this.getActualPage()) {
                case "Home":
                    switch (choice) {
                        case "1":
                            this.setActualPage("Fight");
                            this.resetConsole();
                            System.out.println(enemy + "\n");
                            break;
                        case "2":
                            this.setActualPage("Shop");
                            this.resetConsole();
                            break;
                        case "3":
                            this.resetConsole();
                            System.out.println(knight.toString());
                            break;
                        case "4":
                            this.resetConsole();
                            System.out.println(knight.getInventory() + "\n");
                            break;
                        case "5":
                            this.resetConsole();
                            System.out.println("Your current weapon and shield :\n");
                            System.out.println("Weapon: " + knight.getWeapon().getName() + " (Damage: " + knight.getWeapon().getDamage() +  ", Rarity: " + knight.getWeapon().getRarity() + ")");
                            System.out.println("Shield: " + knight.getShield().getName() + " (Defense: " + knight.getShield().getDefense() +  ", Rarity: " + knight.getShield().getRarity() + ")\n");
                            System.out.println("Charm: " + (knight.getCharm() != null ? knight.getCharm().getName() + " (Defense: " + knight.getShield().getDefense() +  ", Rarity: " + knight.getShield().getRarity() + ")\n" : "You don't have any charms equipped\n"));
                            System.out.println("Equipment in your inventory :\n");
                            System.out.println(knight.getAllWeaponsAndShieldAndCharm());

                            System.out.println("Do you want to change your equipment ? Yes/No");
                            String request = scanner.nextLine();
                            if (request.toLowerCase().equals("yes") || request.toLowerCase().equals("y")) {
                                System.out.println("Weapons, Shield or Charm ?");
                            } else {
                                this.resetConsole();
                                break;
                            } 
                            String weaponsShield = scanner.nextLine();
                            if (weaponsShield.toLowerCase().equals("weapons") || weaponsShield.toLowerCase().equals("w")){
                                System.out.println("Which Weapons do you want ?\n" + knight.getAllUniqueItem("Sword") + "\n");
                                String swordToEquip = scanner.nextLine();
                                if (knight.getAllUniqueItem("Sword").contains(swordToEquip)){
                                    Weapons weaponsBeforeChange = knight.getWeapon();
                                    knight.setWeapon(Weapons.getWeapons(swordToEquip));
                                    knight.inventory.addItem(weaponsBeforeChange.getName(), 1);
                                    knight.inventory.removeItem(swordToEquip, 1);
                                    this.resetConsole();
                                    System.out.println(swordToEquip + " has been equiped succefully");
                                    break;
                                } else{
                                    this.resetConsole();
                                    System.out.println(" You don't have any sword to equip, you can buy it at the shop");
                                    break;
                                }
                            } else if (weaponsShield.toLowerCase().equals("shield") || weaponsShield.toLowerCase().equals("s")){
                                System.out.println("Which Shield do you want ?\n" + knight.getAllUniqueItem("Shield") + "\n");
                                String shieldToEquip = scanner.nextLine();
                                if (knight.getAllUniqueItem("Shield").contains(shieldToEquip)){
                                    Shields shieldBeforeChange = knight.getShield();
                                    knight.setShield(Shields.getShield(shieldToEquip));
                                    knight.inventory.addItem(shieldBeforeChange.getName(), 1);
                                    knight.inventory.removeItem(shieldToEquip, 1);
                                    this.resetConsole();
                                    System.out.println(shieldToEquip + " has been equiped succefully");
                                    break;
                                }else{
                                    this.resetConsole();
                                    System.out.println(" You don't have any shield to equip, you can buy it at the shop");
                                    break;
                                }
                            } else if (weaponsShield.toLowerCase().equals("charm") || weaponsShield.toLowerCase().equals("c")) {
                                System.out.println("Which Charm do you want ?\n" + knight.getAllUniqueItem("Charms") + "\n");
                                String charmToEquip = scanner.nextLine();
                                if (knight.getAllUniqueItem("Charms").contains(charmToEquip)){
                                    Charms charmBeforeChange = knight.getCharm();
                                    knight.setCharm(Charms.getCharm(charmToEquip));
                                    if (charmBeforeChange != null) {
                                        knight.inventory.addItem(charmBeforeChange.getName(), 1);
                                    }
                                    knight.inventory.removeItem(charmToEquip, 1);
                                    this.resetConsole();
                                    System.out.println(charmToEquip + " has been equiped succefully");
                                    break;
                                }
                                else{
                                    this.resetConsole();
                                    System.out.println(" You don't have any charm to equip, you can buy it at the shop");
                                    break;
                                }
                            }
                            
                            else {
                                System.out.println("Bad answer, back to Home \n");
                                setActualPage("Home");
                                this.resetConsole();
                                break;
                            }
                        
                        case "6":
                            this.setActualPage("Exit");
                            this.resetConsole();
                            break;
                        case "7":
                            resetConsole();
                            break;
                        default:
                            this.resetConsole();
                            System.out.println("Invalid choice, please try again.");
                    }
                    break;
                case "Shop":
                    switch (choice) {
                        case "1":
                            this.resetConsole();
                            List<Item> shopItems = shop.displayItem();
                            int shopChoice = scanner.nextInt();
                            if (shopChoice > 0 && shopChoice <= shopItems.size()) {
                                Item selectedItem = shopItems.get(shopChoice - 1);
                                if (knight.getGold() >= selectedItem.getItemPrice()) {
                                    knight.setGold(knight.getGold() - selectedItem.getItemPrice());
                                    knight.getInventory().addItem(selectedItem.getItemName(), 1);
                                    shop.RemoveItem(selectedItem);
                                    this.resetConsole();
                                    this.setActualPage("Home");
                                    System.out.println("You bought a " + selectedItem.getItemName() + "!");
                                } else {
                                    System.out.println("You don't have enough gold to buy this item.");
                                }
                            } else if (shopChoice == shopItems.size() + 1) {
                                this.resetConsole();
                                this.setActualPage("Home");
                            } else {
                                this.resetConsole();
                                System.out.println("Invalid choice, please try again.");
                            }
                            
                            break;
                        case "2":
                            this.resetConsole();
                            this.setActualPage("Home");
                            break;
                        default:
                            this.resetConsole();
                            System.out.println("Invalid choice, please try again.");
                    }
                    break;
                case "Fight":
                    
                    switch (choice) {
                        case "1":
                            this.resetConsole();
                            newLevel.playLevel(knight, enemy);
                            this.setActualPage("Home");
                            break;
                        
                        case "2":
                            this.setActualPage("Home");
                            this.resetConsole();
                            break;
                        default:
                            this.resetConsole();
                            System.out.println("Invalid choice, please try again.");
                    }
                    break;
            
                default:
                    System.out.println("Invalid page, returning to Home.");
                    this.setActualPage("Home");
                    break;
            };
    }

    public static String Home() {
        return  "==================[ HOME ]==================\n" +
                " 1) Fight\n" +
                " 2) Visit Shop\n" +
                " 3) View Stats\n" +
                " 4) View Inventory\n" +
                " 5) Equipment\n" +
                " 6) Exit\n" +
                " 7) Clear Console\n" +
                "============================================";
    }

    public static String Shop(Knight knight) {
        return  "==================[ SHOP ]==================\n" +
                "     ======= You have : " + knight.getGold() + " gold =========\n" +
                " 1) Buy Item\n" +
                " 2) Exit Shop\n" +
                "============================================";
    }

    public static String Fight() {
        return  "==================[ FIGHT ]=================\n" +
                " 1) Advance to Next Level\n" +
                " 2) Run Away\n" +
                "============================================";
    }


    public String getActualPage() {
        return actualPage;
    }

    // Getters and Setters
    public void setActualPage(String actualPage) {
        this.actualPage = actualPage;
    }

    public void resetConsole() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }
}
