package in.ac.adit.pwj.miniproject.inventory;

import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// Inventory Manager class
public class InventoryManager {
    private Map<String, Product> products;
    private Set<String> productIds;

    public InventoryManager() {
        this.products = new HashMap<>();
        this.productIds = new HashSet<>();
    }

    // Inner class for order processing
    public class Order {
        private String productId;
        private int quantity;

        public Order(String productId, int quantity) {
            this.productId = productId;
            this.quantity = quantity;
        }

        public String getProductId() {
            return productId;
        }

        public int getQuantity() {
            return quantity;
        }
    }

    // Method to add product to inventory
    public void addProduct(Product product) {
        if (!productIds.contains(product.getId())) {
            products.put(product.getId(), product);
            productIds.add(product.getId());
            System.out.println("Product added successfully!");
        } else {
            System.out.println("Product already exists in the inventory!");
        }
    }

    // Method to process order
    public void processOrder(Order order) {
        try {
            Product product = products.get(order.getProductId());
            if (product != null) {
                if (product.getQuantity() >= order.getQuantity()) {
                    product.setQuantity(product.getQuantity() - order.getQuantity());
                    System.out.println("Order processed successfully!");
                } else {
                    throw new StockShortageException("Insufficient stock for the product!");
                }
            } else {
                throw new InvalidInputException("Product not found in the inventory!");
            }
        } catch (StockShortageException | InvalidInputException e) {
            System.out.println(e.getMessage());
        }
    }

    // Method to save product data to file
    public void saveProductsToFile() {
        try (FileWriter writer = new FileWriter("products.csv")) {
            for (Product product : products.values()) {
                writer.write(product.getId() + "," + product.getName() + "," + product.getPrice() + "," + product.getQuantity() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving products to file: " + e.getMessage());
        }
    }
    
    // Method to retrieve product data from file
    public void retrieveProductsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("products.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                Product product = new Product(parts[0], parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]));
                products.put(product.getId(), product);
            }
        } catch (IOException e) {
            System.out.println("Error retrieving products from file: " + e.getMessage());
        }
    }    

    // Method to simulate multiple orders being processed concurrently
    public void simulateConcurrentOrders() {
        ExecutorService executor = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            Order order = new Order("P001", 2);
            executor.submit(() -> processOrder(order));
        }
        executor.shutdown();
    }

   
}




