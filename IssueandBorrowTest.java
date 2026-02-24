import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class IssueandBorrowTest {

    private Main.Library library;

    @BeforeEach
    void setup() {
        library = new Main.Library();

        library.addBook(new Main.Book("B101", "Java Programming", 2));
        library.addBook(new Main.Book("B102", "Data Structures", 1));
        library.addUser(new Main.User("U001", "Alice"));
    }

    // ✅ Test successful issue
    @Test
    void testIssueBookSuccess() {
        library.issueBook("U001", "B101");

        Main.Book book = getBook("B101");
        assertEquals(1, book.getAvailableCopies());
    }

    // ✅ Prevent issuing same book twice
    @Test
    void testIssueSameBookTwice() {
        library.issueBook("U001", "B101");
        library.issueBook("U001", "B101");

        Main.Book book = getBook("B101");
        assertEquals(1, book.getAvailableCopies());
    }

    // ✅ Prevent issuing if unavailable
    @Test
    void testIssueWhenUnavailable() {
        library.issueBook("U001", "B102");
        library.issueBook("U001", "B102");

        Main.Book book = getBook("B102");
        assertEquals(0, book.getAvailableCopies());
    }

    // ✅ User not found
    @Test
    void testUserNotFound() {
        library.issueBook("U999", "B101");

        Main.Book book = getBook("B101");
        assertEquals(2, book.getAvailableCopies());
    }

    // ✅ Book not found
    @Test
    void testBookNotFound() {
        library.issueBook("U001", "B999");

        Main.Book book = getBook("B101");
        assertEquals(2, book.getAvailableCopies());
    }

    // Helper method (reflection)
    private Main.Book getBook(String bookId) {
        try {
            var booksField = Main.Library.class.getDeclaredField("books");
            booksField.setAccessible(true);
            var books = (java.util.Map<String, Main.Book>) booksField.get(library);
            return books.get(bookId);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}