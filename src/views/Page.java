package Views;
import java.util.List;
import java.util.Scanner;

import Entities.Entity;
import Entities.Knight;
import Items.Inventory;
import Items.Item;
import Level.Level;
import Shield.Shields;
import Shop.Shop;
import weapons.Weapons;

public class Page {
    private String actualPage = "Home";
    Scanner scanner = new Scanner(System.in);


    public String jumpToPage(Shop shop){
        try {
            switch(actualPage){
                case "Home":
                    return Home();
                case "Shop":
                    return Shop();
                case "Fight":
                    return Fight();
                case "displayShop":
                    return Shop();
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
                            System.out.println(knight.getInventory().getItems().toString() + "\n");
                            break;
                        case "5":
                            this.resetConsole();
                            System.out.println("Your current weapon and shield :\n");
                            System.out.println("Weapon: " + knight.getWeapon().getName() + " (Damage: " + knight.getWeapon().getDamage() +  ", Rarity: " + knight.getWeapon().getRarity() + ")");
                            System.out.println("Shield: " + knight.getShield().getName() + " (Defense: " + knight.getShield().getDefense() +  ", Rarity: " + knight.getShield().getRarity() + ")\n");
                            System.out.println("Equipment in your inventory :\n");
                            System.out.println(knight.getAllWeaponsAndShield());

                            System.out.println("Do you want to change your equipment ? Yes/No");
                            String request = scanner.nextLine();
                            if (request.toLowerCase().equals("yes") || request.toLowerCase().equals("y")) {
                                System.out.println("Weapons or Shield ?");
                            } else {
                                this.resetConsole();
                                break;
                            } 
                            String weaponsShield = scanner.nextLine();
                            if (weaponsShield.toLowerCase().equals("weapons") || weaponsShield.toLowerCase().equals("w")){
                                System.out.println("Which Weapons do you want ?" + knight.getAllSword());
                                String swordToEquip = scanner.nextLine();
                                if (knight.getAllSword().contains(swordToEquip)){
                                    Weapons weaponsBeforeChange = knight.getWeapon();
                                    knight.setWeapon(Weapons.getWeapons(swordToEquip));
                                    knight.inventory.addItem(weaponsBeforeChange.getName(), 1);
                                    this.resetConsole();
                                    System.out.println(swordToEquip + " has been equiped succefully");
                                    break;
                                }
                            } else if (weaponsShield.toLowerCase().equals("shield") || weaponsShield.toLowerCase().equals("s")){
                                System.out.println("Which Shield do you want ?" + knight.getAllShield());
                                String shieldToEquip = scanner.nextLine();
                                if (knight.getAllShield().contains(shieldToEquip)){
                                    Shields shieldBeforeChange = knight.getShield();
                                    knight.setShield(Shields.getShield(shieldToEquip));
                                    knight.inventory.addItem(shieldBeforeChange.getName(), 1);
                                    this.resetConsole();
                                    System.out.println(shieldToEquip + " has been equiped succefully");
                                    break;
                            }} else {
                                System.out.println("Bad answer, back to Home \n");
                                setActualPage("Home");
                                this.resetConsole();
                                break;
                            }
                            

                            break;
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
                            this.setActualPage("displayShop");
                            int shopChoice = scanner.nextInt();
                            if (shopChoice > 0 && shopChoice <= shopItems.size()) {
                                Item selectedItem = shopItems.get(shopChoice - 1);
                                if (knight.getGold() >= selectedItem.getItemPrice()) {
                                    knight.setGold(knight.getGold() - selectedItem.getItemPrice());
                                    knight.getInventory().addItem(selectedItem.getItemName(), 1);
                                    shop.RemoveItem(selectedItem);
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

    public static String Home(){
        return "1. Fight\n2. Visit Shop\n3. View Stats \n4. View Inventory \n5. Equipment \n6. Exit \n7. Clear Console ";
    }

    public static String Shop(){
        return "1. Buy Item\n2. Exit Shop";
    }

    public static String Fight(){
        return "1. Do you want to go to next level ?\n2. Run";
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
