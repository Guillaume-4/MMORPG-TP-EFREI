package Shop;
import java.util.ArrayList;

import Items.Item;
import java.util.List;

public class Shop {
    private Item item;
    ArrayList<Item> listItem;


    // Constructor

    public Shop() {
        this.listItem = new ArrayList<>();
    }

    // Functions
    public List<Item> displayItem() {
        var compteur = 1;
        System.out.println("Items available in the shop:\n");
        for (Item item : listItem) {
            System.out.println(compteur + ". " + item.getItemName() + ": " + item.getItemPrice() + " gold");
            compteur++;
        }
        System.out.println(compteur + ". Exit");
        return listItem;
    }

    public String getItemsForSave() {
        StringBuilder itemsForSave = new StringBuilder();
        for (Item item : listItem) {
            itemsForSave.append(item.getItemName()).append(":").append(item.getItemPrice()).append(",");
        }
        // Remove the trailing comma if necessary
        if (itemsForSave.length() > 0) {
            itemsForSave.setLength(itemsForSave.length() - 1);
        }
        return itemsForSave.toString();
    }

    public void setItemsFromSave(String itemsString) {
        this.listItem.clear(); // Clear existing items
        if (itemsString == null || itemsString.isEmpty()) {
            return; // No items to load
        }
        String[] itemsArray = itemsString.split(",");
        for (String itemData : itemsArray) {
            String[] parts = itemData.split(":");
            if (parts.length == 2) {
                String itemName = parts[0];
                int itemPrice;
                try {
                    itemPrice = Integer.parseInt(parts[1]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid price for item: " + itemName);
                    continue; // Skip this item if price is invalid
                }
                Item item = new Item(itemName, itemPrice);
                this.listItem.add(item);
            }
        }
    }
    

    public void AddItem(Item item) {
        this.listItem.add(item);
    }

    public void RemoveItem(Item item) {
        this.listItem.remove(item);
    }

    // Getters and Setters
    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }
}
