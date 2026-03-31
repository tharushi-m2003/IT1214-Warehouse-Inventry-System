import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private HashMap<String, Item> items;

    // Constructor
    public Inventory() {
        items = new HashMap<>();
    }

    // Add item
    public void addItem(Item item) {
        if (items.containsKey(item.getItemId())) {
            System.out.println("Item ID already exists!");
        } else {
            items.put(item.getItemId(), item);
            System.out.println("Item added successfully.");
        }
    }

    // Remove item
    public void removeItem(String itemId) {
        if (items.containsKey(itemId)) {
            items.remove(itemId);
            System.out.println("Item removed successfully.");
        } else {
            System.out.println("Item not found.");
        }
    }

    // Update quantity
    public void updateQuantity(String itemId, int newQuantity) {
        if (items.containsKey(itemId)) {
            items.get(itemId).setQuantity(newQuantity);
            System.out.println("Quantity updated successfully.");
        } else {
            System.out.println("Item not found.");
        }
    }

    // Search by ID
    public void searchById(String itemId) {
        if (items.containsKey(itemId)) {
            System.out.println(items.get(itemId));
        } else {
            System.out.println("Item not found.");
        }
    }

    // Search by Name
    public void searchByName(String itemName) {
        boolean found = false;

        for (Item item : items.values()) {
            if (item.getItemName().equalsIgnoreCase(itemName)) {
                System.out.println(item);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Item not found.");
        }
    }

    // Display all items
    public void displayAllItems() {
        if (items.isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        System.out.println("\n===== Inventory Items =====");
        for (Map.Entry<String, Item> entry : items.entrySet()) {
            System.out.println(entry.getValue());
        }
    }
}