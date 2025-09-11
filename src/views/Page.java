package Views;
import Entities.Entity;
import Entities.Knight;
import Level.Level;
import Shop.Shop;

public class Page {
    private String actualPage = "Home";
    Level newLevel = new Level(1);


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
                    displayShop(shop);
                    return "";
                default:
                    return "Invalid page";
            }
        } catch (Exception e) {
            return "Error : " + e.getMessage();
        }
        
    }


    // Methods to display pages

    public void goToPage(String choice, Shop shop, Knight knight, Entity enemy){
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
                            this.setActualPage("Exit");
                            this.resetConsole();
                            break;
                        case "5":
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
                            displayShop(shop);
                            this.setActualPage("displayShop");
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
                case "shopDisplay":
                switch (choice) {
                    case "1":
                        this.resetConsole();
                        displayShop(shop);
                        break;
                    case "3":
                        this.setActualPage("Shop");
                        this.resetConsole();
                        break;
                }
            
                default:
                    System.out.println("Invalid page, returning to Home.");
                    this.setActualPage("Home");
                    break;
            };
    }

    public static String Home(){
        return "1. Fight\n2. Visit Shop\n3. View Stats \n4. Exit \n5. Clear Console ";
    }

    public static String Shop(){
        return "1. Buy Item\n2. Exit Shop";
    }

    public static String Fight(){
        return "1. Do you want to go to next level ?\n2. Run";
    }


    public static void displayShop(Shop shop){
        shop.displayItem();
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
