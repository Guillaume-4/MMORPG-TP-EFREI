import java.util.ArrayList;

public class Shop {
    Item item;
    ArrayList<Item> listItem;


    // Constructor

    public Shop() {
        this.listItem = new ArrayList<>();
    }

    // Functions
    public void displayItem() {
        System.out.println("Items available in the shop:");
        for (Item item : listItem) {
            System.out.println("- " + item.getItemName() + ": " + item.getItemPrice() + " gold");
        }
    }

    public void AddItem(Item item) {
        this.listItem.add(item);
    }

    // Getters and Setters
    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }
}
