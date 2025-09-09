package shop;
import java.util.ArrayList;

import items.Item;

public class Shop {
    private Item item;
    ArrayList<Item> listItem;


    // Constructor

    public Shop() {
        this.listItem = new ArrayList<>();
    }

    // Functions
    public void displayItem() {
        var compteur = 1;
        System.out.println("Items available in the shop:");
        for (Item item : listItem) {
            System.out.println(compteur + item.getItemName() + ": " + item.getItemPrice() + " gold");
            compteur++;
        }
        System.out.println(compteur + "Exit");
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
