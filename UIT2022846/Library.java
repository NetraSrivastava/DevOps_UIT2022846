package UIT2022846;

import java.util.HashSet;
import java.util.Set;

public class Library {

    private Set<String> books = new HashSet<>();

    public void addBook(String bookName) {
        books.add(bookName);
    }

    public boolean isAvailable(String bookName) {
        return books.contains(bookName);
    }

    public boolean issueBook(String bookName) {
        if (books.contains(bookName)) {
            books.remove(bookName);
            return true;
        }
        return false;
    }
}

