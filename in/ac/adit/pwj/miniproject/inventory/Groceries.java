package in.ac.adit.pwj.miniproject.inventory;

// Groceries product class inheriting from Product
public class Groceries extends Product {
    private String expirationDate;

    public Groceries(String id, String name, double price, int quantity, String expirationDate) {
        super(id, name, price, quantity);
        this.expirationDate = expirationDate;
    }

    public String getExpirationDate() {
        return expirationDate;
    }

    @Override
    public String toString() {
        return super.toString() + ", Expiration Date: " + expirationDate + " (Groceries)";
    }

}

