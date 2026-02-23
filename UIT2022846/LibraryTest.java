package UIT2022846;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LibraryTest {

    @Test
    void testAddBook() {
        Library lib = new Library();
        lib.addBook("Java");
        assertTrue(lib.isAvailable("Java"));
    }

    @Test
    void testIssueBook() {
        Library lib = new Library();
        lib.addBook("Python");

        boolean issued = lib.issueBook("Python");

        assertTrue(issued);
        assertFalse(lib.isAvailable("Python"));
    }
}
