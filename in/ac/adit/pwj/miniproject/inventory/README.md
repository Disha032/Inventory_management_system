# Inventory Management System 
This is a **Java-based Inventory Management System** built as a mini project for learning and demonstration purposes. It allows users to manage different product types,
handle stock, and simulate real-world inventory operations like concurrent orders.

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

## Project Structure
Miniproject/ 
└── in/ 
└── ac/ 
└── adit/
└── pwj/ 
└── miniproject/ 
└── inventory/
├── Electronics.java
├── Groceries.java
├── InvalidInputException.java 
├── InventoryManager.java
├── Main.java 
├── Product.java 
├── StockShortageException.java  
└── products.csv


--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

##  Features

-  Add Electronics or Grocery products with specific attributes  
-  Save and retrieve products from a file (`products.csv`)  
-  Delete products  
-  Process customer orders  
-  Check for low stock  
-  **Simulate concurrent orders** with multiple threads  
-  Automatically ignore `.class` files using `.gitignore`

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

## How Simulate Concurrent Orders Works

The system uses Java’s `ExecutorService` to simulate multiple customers placing orders **at the same time**.  
You can enter:
- Product ID  
- Quantity per customer  
- Number of customers placing orders

It then displays whether the order was successful or failed due to stock shortage, with visible remaining stock.

---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

## Technologies Used

- Java SE 8  
- Java Collections Framework  
- Concurrency with `ExecutorService`  
- File I/O (`BufferedReader`, `FileWriter`)  
- Custom Exceptions  
- Thread synchronization (`synchronized` block)

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

##  Requirements

- Java Development Kit (JDK) 8 or later  
- Any IDE or code editor (e.g., VS Code)  
- Git for version control

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

##  How to Run

1. Clone the repository
   git clone https://github.com/Disha032/Inventory_management_system.git
2. Open in VS Code or your preferred Java IDE  
3. Compile and run 'Main.java'  
4. Use the menu in the terminal to interact with the system

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

##  Author

**Disha032**  
 [GitHub Profile] : (https://github.com/Disha032)

--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

##  Notes

- `.class` files are excluded from version control using `.gitignore`
- Make sure to save data using option `3` (Save to File) if you want to retain it after exiting
- To simulate concurrency effectively, observe the stock decrease in real time!

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

## 📷 Screenshots (Optional)

> 


   


