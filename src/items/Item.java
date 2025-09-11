package Items;

public class Item {
    private String itemName;
    private int itemPrice;

    // Constructor

    public Item(String itemName, int itemPrice) {
        this.itemName = itemName;
        this.itemPrice = itemPrice;
    }

    // Getters and Setters

    public String getItemName() {
        return itemName;
    }
    public int getItemPrice() {
        return itemPrice;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
    public void setItemPrice(int itemPrice) {
        this.itemPrice = itemPrice;
    }

}
