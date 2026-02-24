mport java.util.*;

// =======================
// 📌 MAIN CLASS
// =======================
public class Main {

    // =======================
    // 📚 BOOK CLASS
    // =======================
    static class Book {
        private String bookId;
        private String title;
        private int availableCopies;

        public Book(String bookId, String title, int availableCopies) {
            this.bookId = bookId;
            this.title = title;
            this.availableCopies = availableCopies;
        }

        public String getBookId() {
            return bookId;
        }

        public String getTitle() {
            return title;
        }

        public int getAvailableCopies() {
            return availableCopies;
        }

        public void decreaseCopies() {
            availableCopies--;
        }
    }

    // =======================
    // 👤 USER CLASS
    // =======================
    static class User {
        private String userId;
        private String name;
        private Set<String> borrowedBooks;

        public User(String userId, String name) {
            this.userId = userId;
            this.name = name;
            this.borrowedBooks = new HashSet<>();
        }

        public String getUserId() {
            return userId;
        }

        public boolean hasBorrowed(String bookId) {
            return borrowedBooks.contains(bookId);
        }

        public void borrowBook(String bookId) {
            borrowedBooks.add(bookId);
        }
    }

    // =======================
    // 🏛 LIBRARY CLASS
    // =======================
    static class Library {
        private Map<String, Book> books = new HashMap<>();
        private Map<String, User> users = new HashMap<>();

        public void addBook(Book book) {
            books.put(book.getBookId(), book);
        }

        public void addUser(User user) {
            users.put(user.getUserId(), user);
        }

        // 📌 ISSUE BOOK METHOD
        public void issueBook(String userId, String bookId) {

            if (!users.containsKey(userId)) {
                System.out.println("❌ User not found!");
                return;
            }

            if (!books.containsKey(bookId)) {
                System.out.println("❌ Book not found!");
                return;
            }

            User user = users.get(userId);
            Book book = books.get(bookId);

            // Prevent issuing same book twice
            if (user.hasBorrowed(bookId)) {
                System.out.println("❌ User already borrowed this book!");
                return;
            }

            // Prevent issuing if unavailable
            if (book.getAvailableCopies() <= 0) {
                System.out.println("❌ Book is currently unavailable!");
                return;
            }

            // Issue book
            book.decreaseCopies();
            user.borrowBook(bookId);

            System.out.println("✅ Book issued successfully!");
        }
    }

    // =======================
    // 🚀 MAIN METHOD
    // =======================
    public static void main(String[] args) {

        Library library = new Library();

        // Add Books
        library.addBook(new Book("B101", "Java Programming", 2));
        library.addBook(new Book("B102", "Data Structures", 1));

        // Add Users
        library.addUser(new User("U001", "Alice"));

        // Test Cases
        library.issueBook("U001", "B101");  // Success
        library.issueBook("U001", "B101");  // Already borrowed
        library.issueBook("U001", "B102");  // Success
        library.issueBook("U001", "B102");  // Unavailable
        library.issueBook("U002", "B101");  // User not found
    }
}