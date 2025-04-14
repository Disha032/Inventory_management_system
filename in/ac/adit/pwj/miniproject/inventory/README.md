# Inventory Management System 
This is a **Java-based Inventory Management System** built as a mini project for learning and demonstration purposes. It allows users to manage different product types,
handle stock, and simulate real-world inventory operations like concurrent orders.

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

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

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

##  Features

-  Add Electronics or Grocery products with specific attributes  
-  Save and retrieve products from a file ('products.csv')  
-  Delete products  
-  Process customer orders  
-  Check for low stock  
-  **Simulate concurrent orders** with multiple threads  
-  Automatically ignore '.class' files using '.gitignore'

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

## How Simulate Concurrent Orders Works

The system uses Java’s `ExecutorService` to simulate multiple customers placing orders **at the same time**.  
You can enter:
- Product ID  
- Quantity per customer  
- Number of customers placing orders

It then displays whether the order was successful or failed due to stock shortage, with visible remaining stock.

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

## Technologies Used

- Java SE 8  
- Java Collections Framework  
- Concurrency with 'ExecutorService'  
- File I/O ('BufferedReader', 'FileWriter')  
- Custom Exceptions  
- Thread synchronization ('synchronized' block)

------------------------------------------------------------------------------------------------------------------------------------------------------------------------------

##  Requirements

- Java Development Kit (JDK) 8 or later  
- Any IDE or code editor (e.g., VS Code)  
- Git for version control

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

##  How to Run

1. Clone the repository
   git clone https://github.com/Disha032/Inventory_management_system.git
2. Open in VS Code or your preferred Java IDE  
3. Compile and run 'Main.java'  
4. Use the menu in the terminal to interact with the system

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

##  Notes

- '.class' files are excluded from version control using '.gitignore'
- Make sure to save data using option '3' (Save to File) if you want to retain it after exiting
- To simulate concurrency effectively, observe the stock decrease in real time!

-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------

##  Screenshots 

> ![Retrieve Products from file for previously stored data](https://github.com/user-attachments/assets/47a750c0-800f-4653-94a5-ebd8022cf4de)

>  The user selects option 4 to load products from a saved file. A confirmation message "Products loaded successfully!" appears, indicating the retrieval of data from          storage.

> ![Display Products](https://github.com/user-attachments/assets/0cf3d08b-f0ed-46a7-9ec4-c0d16b21fec8)

> The user selected option 8, "Display All Products," which presents a comprehensive list of the inventory. The displayed information includes product ID, name, price,        quantity, expiration date (for groceries), and brand (for electronics), with each product categorized as either "Groceries" or "Electronics."

> ![Add Product](https://github.com/user-attachments/assets/8c191328-139a-4c58-b87a-ef0cdae79261)

>    Option 1, "Add Product," was chosen by the user to add a new item to the inventory. The user provided details such as product type ("Groceries"), product ID ("P024"),       name ("Wheat"), price (2200), quantity (6), and expiration date ("12/7/2027"). The system confirmed the successful addition of the product.
 
> ![Process Order](https://github.com/user-attachments/assets/dc577911-51de-406e-9c57-2cdce5f75aee)

>  The user selected option 2, "Process Order," to fulfill a customer order. The user entered the product ID "P022" and the quantity "1."
   The system successfully processed the order, as indicated by the "Order processed successfully!" message.
 
> ![Display Products After Adding Products and processing order](https://github.com/user-attachments/assets/f816324b-cf78-4533-9e02-f951faf668f1)

>  Option 8, "Display All Products," was selected, showcasing the current inventory. The output lists each product's ID, name, price, quantity, along with either
   the expiration date (for "Groceries") or brand (for "Electronics"), clearly categorizing each item.
 
> ![Save Products to file and Retrieve Products from file](https://github.com/user-attachments/assets/5626440c-35ef-40e0-91f8-1d22b06d61ba)

> This screenshot shows two sequential actions. First, option 3, "Save Products to File," was executed, successfully saving the inventory data to a file, as indicated by      the "Products saved successfully!" message. Subsequently, option 4, "Retrieve Products from File," was used to load the saved inventory, which was also successful,          displaying the "Products loaded successfully!" message.
 
> ![Check Low Stock](https://github.com/user-attachments/assets/ab31d058-2f5b-4c07-85c4-12ba52601fab)

>   Option 5, "Check Low Stock," was used, displaying a low stock warning for "Mixture" (Qty: 4).

> ![simulate concurrent Orders](https://github.com/user-attachments/assets/969d92fd-2208-4d33-8ed8-6f07e3da1478)

> Option 6, "Simulate Concurrent Orders," was executed. The system processed 4 orders, with 2 successful (resulting in stock updates) and 2 rejected due to reaching the       maximum allowed successful orders.
 
> ![Delete Product](https://github.com/user-attachments/assets/a7105079-7467-43eb-a2c8-6eef05fe0431)

>  Option 7, "Delete Product," was used to remove a product from the inventory. The user entered the product ID "P023," and the system confirmed the successful deletion of    the product.
 
> ![Display Products After deleting and processing order](https://github.com/user-attachments/assets/2f03a16c-abbd-4b8c-a0fc-c1541963f245)

>  After choosing option 8, all available products are listed with details    such as ID, name, price, quantity, and either brand (for electronics) or    expiration date       (for groceries).

> ![Exit](https://github.com/user-attachments/assets/b0a3767b-4601-4546-bf22-1c696cbf195b)

>  Option 9, "Exit," was chosen by the user, resulting in the termination of the Inventory Management System. The "Exiting..." message confirms the action, and the command    prompt displays the current directory of the application.




   


