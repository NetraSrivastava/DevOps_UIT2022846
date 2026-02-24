package Library_Management_System;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ReturnBook {

private static final int FINE_PER_DAY = 5; // Rs 5 per day fine

public int returnBook(LocalDate issueDate, LocalDate returnDate) {

long daysBetween = ChronoUnit.DAYS.between(issueDate, returnDate);

int allowedDays = 14; // 14 days allowed borrowing

if (daysBetween <= allowedDays) {
return 0; // No fine
} else {
long lateDays = daysBetween - allowedDays;
return (int) lateDays * FINE_PER_DAY;
}
}
}