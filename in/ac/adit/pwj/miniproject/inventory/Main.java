package in.ac.adit.pwj.miniproject.inventory;

public class Main {
    public static void main(String args[]){
        InventoryManager inventoryManager = new InventoryManager();

        // Add products to inventory
        Product product1 = new Electronics("P001", "Laptop", 50000, 10, "Dell");
        Product product2 = new Groceries("P002", "Rice", 50, 20, "2024-12-31");
        inventoryManager.addProduct(product1);
        inventoryManager.addProduct(product2);

        // Process orders
        InventoryManager.Order order1 = inventoryManager.new Order("P001", 2);
        InventoryManager.Order order2 = inventoryManager.new Order("P002", 5);
        inventoryManager.processOrder(order1);
        inventoryManager.processOrder(order2);

        // Save product data to file
        inventoryManager.saveProductsToFile();

        // Retrieve product data from file
        inventoryManager.retrieveProductsFromFile();

        // Simulate multiple orders being processed concurrently
        inventoryManager.simulateConcurrentOrders();
    }
}

