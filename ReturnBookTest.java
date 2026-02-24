package Library_Management_System;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;

public class ReturnBookTest {

ReturnBook service = new ReturnBook();

@Test
void testReturnWithinTime() {
LocalDate issueDate = LocalDate.of(2024, 1, 1);
LocalDate returnDate = LocalDate.of(2024, 1, 10);

int fine = service.returnBook(issueDate, returnDate);

assertEquals(0, fine);
}

@Test
void testReturnLate() {
LocalDate issueDate = LocalDate.of(2024, 1, 1);
LocalDate returnDate = LocalDate.of(2024, 1, 20);

int fine = service.returnBook(issueDate, returnDate);

assertEquals(25, fine); // 6 late days × 5 Rs
}

@Test
void testReturnOnExactDueDate() {
LocalDate issueDate = LocalDate.of(2024, 1, 1);
LocalDate returnDate = LocalDate.of(2024, 1, 15);

int fine = service.returnBook(issueDate, returnDate);

assertEquals(0, fine);
}
}