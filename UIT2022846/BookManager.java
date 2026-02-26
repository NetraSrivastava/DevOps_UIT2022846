package UIT2022846;

import java.util.HashMap;
import java.util.Map;

public class BookManager {

    private Map<String, Integer> inventory = new HashMap<>();

    // Add new book or increase copies
    public void addBook(String bookName, int copies) {
        if (copies <= 0) {
            System.out.println("Invalid number of copies.");
            return;
        }

        inventory.put(bookName,
                inventory.getOrDefault(bookName, 0) + copies);
    }

    // Check availability
    public boolean isAvailable(String bookName) {
        return inventory.containsKey(bookName)
                && inventory.get(bookName) > 0;
    }

    // Issue a book
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

    // View all books
    public void displayBooks() {
        System.out.println("Library Inventory:");
        for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
            System.out.println(entry.getKey() +
                    " : " + entry.getValue() + " copies");
        }
    }
}