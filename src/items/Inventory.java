package Items;

import java.util.HashMap;

public class Inventory {
    private HashMap<String, Integer> items;

    public Inventory() {
        this.items = new HashMap<>();
    }

    public void addItem(String item, int quantity) {
        items.put(item, items.getOrDefault(item, 0) + quantity);
    }

    public void removeItem(String item, int quantity) {
        if(items.getOrDefault(item, 0) < quantity) {
            System.out.println("Not enough " + item + " in inventory.");
            return;
        }else if (items.get(item) == quantity) {
            items.remove(item);
            return;
        }else{
            items.put(item, items.getOrDefault(item, 0) - quantity);
        }
    }

    public HashMap<String, Integer> getItems() {
        return items;
    }
}
