package in.ac.adit.pwj.miniproject.inventory;

// Custom exception for stock shortage
public class StockShortageException extends Exception {
    public StockShortageException(String message) {
        super(message);
    }
}

