package in.ac.adit.pwj.miniproject.inventory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        InventoryManager manager = new InventoryManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Process Order");
            System.out.println("3. Save Products to File");
            System.out.println("4. Retrieve Products from File");
            System.out.println("5. Check Low Stock");
            System.out.println("6. Simulate Concurrent Orders");
            System.out.println("7. Delete Product");
            System.out.println("8. Display All Products");
            System.out.println("9. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter product type (Electronics/Groceries): ");
                    String type = scanner.nextLine();

                    System.out.print("Enter product ID: ");
                    String id = scanner.nextLine();

                    System.out.print("Enter product name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();

                    System.out.print("Enter quantity: ");
                    int quantity = scanner.nextInt();
                    scanner.nextLine();  // consume newline

                    if (type.equalsIgnoreCase("Electronics")) {
                        System.out.print("Enter brand: ");
                        String brand = scanner.nextLine();
                        Electronics e = new Electronics(id, name, price, quantity, brand);
                        manager.addProduct(e);
                    } else if (type.equalsIgnoreCase("Groceries")) {
                        System.out.print("Enter expiration date: ");
                        String expiry = scanner.nextLine();
                        Groceries g = new Groceries(id, name, price, quantity, expiry);
                        manager.addProduct(g);
                    } else {
                        System.out.println("Invalid product type!");
                    }
                    break;

                case 2:
                    System.out.print("Enter product ID to order: ");
                    String orderId = scanner.nextLine();

                    System.out.print("Enter quantity to order: ");
                    int orderQty = scanner.nextInt();
                    scanner.nextLine();

                    InventoryManager.Order order = manager.new Order(orderId, orderQty);
                    manager.processOrder(order);
                    break;

                case 3:
                    manager.saveProductsToFile();
                    break;

                case 4:
                    manager.retrieveProductsFromFile();
                    break;

                case 5:
                    // Low stock warning
                    for (Product product : manager.getAllProducts()) {
                        if (product.getQuantity() < 5) {
                            System.out.println("Warning: Low stock for " + product.getName() + " (Qty: " + product.getQuantity() + ")");
                        }
                    }
                    break;

                case 6:
                    manager.simulateConcurrentOrders();
                    break;

                case 7:
                    System.out.print("Enter product ID to delete: ");
                    String deleteId = scanner.nextLine();
                    manager.deleteProduct(deleteId);
                    break;

                case 8:
                    manager.displayAllProducts();
                    break;

                case 9:
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
