

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BookManagerTest {

    @Test
    void testAddBook() {
        BookManager manager = new BookManager();
        manager.addBook("Java", 3);

        assertEquals(3, manager.getCopies("Java"));
    }

    @Test
    void testIssueBook() {
        BookManager manager = new BookManager();
        manager.addBook("Python", 2);

        boolean issued = manager.issueBook("Python");

        assertTrue(issued);
        assertEquals(1, manager.getCopies("Python"));
    }

    @Test
    void testReturnBook() {
        BookManager manager = new BookManager();
        manager.addBook("C++", 1);
        manager.issueBook("C++");

        manager.returnBook("C++");

        assertEquals(1, manager.getCopies("C++"));
    }

    @Test
    void testUnavailableBook() {
        BookManager manager = new BookManager();

        assertFalse(manager.issueBook("Unknown"));
    }
}