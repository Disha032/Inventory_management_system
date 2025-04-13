package in.ac.adit.pwj.miniproject.inventory;

import java.io.*;
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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

    // Method to delete a product by ID
    public void deleteProduct(String productId) {
        if (products.containsKey(productId)) {
            products.remove(productId);
            productIds.remove(productId);
            System.out.println("Product deleted successfully!");
        } else {
            System.out.println("Product not found.");
        }
    }

    // Method to display all products
    public void displayAllProducts() {
        if (products.isEmpty()) {
            System.out.println("No products in the inventory.");
            return;
        }

        System.out.println("All Products:");
        for (Product product : products.values()) {
            System.out.println(product);
        }
    }

    // Method to process order
    public void processOrder(Order order) {
        try {
            Product product = products.get(order.getProductId());
            if (product != null) {
                int currentQty = product.getQuantity();
                int orderQty = order.getQuantity();
    
                if (currentQty >= orderQty) {
                    int newQty = currentQty - orderQty;
                    product.setQuantity(newQty);
                    System.out.println("Order processed successfully!");
    
                    // Reuse the exception to warn about low stock
                    if (newQty < 5) {
                        throw new StockShortageException("Warning: Stock for " + product.getName() + " is running low! (Only " + newQty + " left)");
                    }
    
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
        try (FileWriter writer = new FileWriter("C:\\Users\\ADMIN\\Miniproject\\in\\ac\\adit\\pwj\\miniproject\\inventory\\products.csv")) {
            for (Product product : products.values()) {
                if (product instanceof Electronics) {
                    Electronics e = (Electronics) product;
                    writer.write("Electronics," + e.getId() + "," + e.getName() + "," + e.getPrice() + "," + e.getQuantity() + "," + e.getBrand() + "\n");
                } else if (product instanceof Groceries) {
                    Groceries g = (Groceries) product;
                    writer.write("Groceries," + g.getId() + "," + g.getName() + "," + g.getPrice() + "," + g.getQuantity() + "," + g.getExpirationDate() + "\n");
                }
            }
        } catch (IOException e) {
            System.out.println("Error saving products to file: " + e.getMessage());
        }
    }    
    
    // Method to retrieve product data from file
    public void retrieveProductsFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader("C:\\Users\\ADMIN\\Miniproject\\in\\ac\\adit\\pwj\\miniproject\\inventory\\products.csv"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String type = parts[0];
                if (type.equals("Electronics")) {
                    Product e = new Electronics(parts[1], parts[2], Double.parseDouble(parts[3]), Integer.parseInt(parts[4]), parts[5]);
                    products.put(e.getId(), e);
                } else if (type.equals("Groceries")) {
                    Product g = new Groceries(parts[1], parts[2], Double.parseDouble(parts[3]), Integer.parseInt(parts[4]), parts[5]);
                    products.put(g.getId(), g);
                }
            }
        } catch (IOException e) {
            System.out.println("Error retrieving products from file: " + e.getMessage());
        }
    }    

    // Method to simulate multiple orders being processed concurrently
    public void simulateConcurrentOrders(Scanner scanner) {
        System.out.print("Enter product ID to order: ");
        String productId = scanner.nextLine();
    
        System.out.print("Enter quantity to order per customer: ");
        int quantity = Integer.parseInt(scanner.nextLine());
    
        System.out.print("Enter number of customers placing orders: ");
        int numberOfOrders = Integer.parseInt(scanner.nextLine());
    
        Product product = products.get(productId);
        if (product == null) {
            System.out.println("Product not found.");
            return;
        }
    
        ExecutorService executor = Executors.newFixedThreadPool(5);
    
        for (int i = 0; i < numberOfOrders; i++) {
            executor.submit(() -> {
                synchronized (this) {
                    if (product.getQuantity() >= quantity) {
                        product.setQuantity(product.getQuantity() - quantity);
                        System.out.println("Order successful! Remaining stock: " + product.getQuantity());
                    } else {
                        System.out.println("Order failed! Not enough stock. Remaining stock: " + product.getQuantity());
                    }
                }
            });
        }
    
        executor.shutdown();
        try {
            executor.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            System.out.println("Order processing was interrupted.");
        }
    
        System.out.println("All orders processed.");
    }    

    // Method to check for stock shortages
    public void checkStock() throws StockShortageException {
        boolean shortageFound = false;

        for (Product product : products.values()) {
            if (product.getQuantity() < 5) {
                shortageFound = true;
                throw new StockShortageException(
                    "Low stock for product: " + product.getName() + " (Quantity: " + product.getQuantity() + ")"
                );
            }
        }

        if (!shortageFound) {
            System.out.println("All products have sufficient stock.");
        }
    }

    public Collection<Product> getAllProducts() {
        return products.values();
    }
    
   
}




