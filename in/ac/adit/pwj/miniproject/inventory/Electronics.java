package in.ac.adit.pwj.miniproject.inventory;

// Electronics product class inheriting from Product
public class Electronics extends Product {
    private String brand;

    public Electronics(String id, String name, double price, int quantity, String brand) {
        super(id, name, price, quantity);
        this.brand = brand;
    }

    public String getBrand() {
        return brand;
    }
}

