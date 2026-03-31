import java.util.Scanner;

public class Warehouse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Inventory inventory = new Inventory();

        int choice;

        do {
            System.out.println("\n===== Warehouse Inventory Management System =====");
            System.out.println("1. Add New Item");
            System.out.println("2. Remove Item");
            System.out.println("3. Update Item Quantity");
            System.out.println("4. Search Item by ID");
            System.out.println("5. Search Item by Name");
            System.out.println("6. Display All Items");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Item ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Enter Item Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Quantity: ");
                    int quantity = scanner.nextInt();

                    System.out.print("Enter Price: ");
                    double price = scanner.nextDouble();
                    scanner.nextLine();

                    if (quantity < 0 || price < 0) {
                        System.out.println("Invalid quantity or price.");
                        break;
                    }

                    Item item = new Item(id, name, quantity, price);
                    inventory.addItem(item);
                    break;

                case 2:
                    System.out.print("Enter Item ID to remove: ");
                    String removeId = scanner.nextLine();
                    inventory.removeItem(removeId);
                    break;

                case 3:
                    System.out.print("Enter Item ID: ");
                    String updateId = scanner.nextLine();

                    System.out.print("Enter New Quantity: ");
                    int newQty = scanner.nextInt();
                    scanner.nextLine();

                    if (newQty < 0) {
                        System.out.println("Quantity cannot be negative.");
                        break;
                    }

                    inventory.updateQuantity(updateId, newQty);
                    break;

                case 4:
                    System.out.print("Enter Item ID to search: ");
                    String searchId = scanner.nextLine();
                    inventory.searchById(searchId);
                    break;

                case 5:
                    System.out.print("Enter Item Name to search: ");
                    String searchName = scanner.nextLine();
                    inventory.searchByName(searchName);
                    break;

                case 6:
                    inventory.displayAllItems();
                    break;

                case 7:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 7);

        scanner.close();
    }
}