
import java.util.HashMap;
import java.util.Map;

public class BookManager {

    private Map<String, Integer> inventory = new HashMap<>();

    // Add book with number of copies
    public void addBook(String bookName, int copies) {
        if (copies <= 0) {
            return;
        }

        inventory.put(bookName,
                inventory.getOrDefault(bookName, 0) + copies);
    }

    // Check availability
    public boolean isAvailable(String bookName) {
        return inventory.getOrDefault(bookName, 0) > 0;
    }

    // Issue book
    public boolean issueBook(String bookName) {
        if (isAvailable(bookName)) {
            inventory.put(bookName, inventory.get(bookName) - 1);
            return true;
        }
        return false;
    }

    // Return book
    public void returnBook(String bookName) {
        inventory.put(bookName,
                inventory.getOrDefault(bookName, 0) + 1);
    }

    // Get number of copies
    public int getCopies(String bookName) {
        return inventory.getOrDefault(bookName, 0);
    }
}