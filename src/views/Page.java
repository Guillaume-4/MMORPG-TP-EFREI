package views;
import shop.Shop;

public class Page {
    private String actualPage = "Home";


    public String jumpToPage(){
        try {
            switch(actualPage){
                case "Home":
                    return Home();
                case "Shop":
                    return Shop();
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

    public void goToPage(String choice, Shop shop){
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
                            this.setActualPage("Exit");
                            this.resetConsole();
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
                            this.setActualPage("shopDisplay");
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
                            System.out.println("You attacked the enemy!");
                            break;
                        case "2":
                            this.resetConsole();
                            System.out.println("You are guarding!");
                            break;
                        case "3":
                            this.resetConsole();
                            System.out.println("You used an item!");
                            break;
                        case "4":
                            this.setActualPage("Home");
                            this.resetConsole();
                            break;
                        default:
                            this.resetConsole();
                            System.out.println("Invalid choice, please try again.");
                    }
                    break;
                case "shopDisplay":
                    this.resetConsole();
                    displayShop(shop);
                    break;
                default:
                    System.out.println("Invalid page, returning to Home.");
                    this.setActualPage("Home");
                    break;
            };
    }

    public static String Home(){
        return "1. Fight\n2. Visit Shop\n3. Exit";
    }

    public static String Shop(){
        return "1. Buy Item\n2. Exit Shop";
    }

    public static String Fight(){
        return "1. Attack\n2. Guard\n3. Use Item\n4. Run";
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
