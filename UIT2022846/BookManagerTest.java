package UIT2022846;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookManagerTest {

    @Test
    void testAddBook() {
        BookManager manager = new BookManager();
        manager.addBook("DSA", 3);

        assertTrue(manager.isAvailable("DSA"));
    }

    @Test
    void testIssueBook() {
        BookManager manager = new BookManager();
        manager.addBook("Java", 2);

        boolean issued = manager.issueBook("Java");

        assertTrue(issued);
    }

    @Test
    void testReturnBook() {
        BookManager manager = new BookManager();
        manager.addBook("Python", 1);
        manager.issueBook("Python");

        manager.returnBook("Python");

        assertTrue(manager.isAvailable("Python"));
    }
}