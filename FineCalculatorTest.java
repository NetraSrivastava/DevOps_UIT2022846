import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FineCalculatorTest {

    @Test
    void testFineWhenZeroDays() {
        FineCalculator calculator = new FineCalculator();
        assertEquals(0, calculator.calculateFine(0));
    }

    @Test
    void testFineForFiveDays() {
        FineCalculator calculator = new FineCalculator();
        assertEquals(25, calculator.calculateFine(5));
    }

    @Test
    void testFineForLargeDays() {
        FineCalculator calculator = new FineCalculator();
        assertEquals(500, calculator.calculateFine(100));
    }

    @Test
    void testNegativeDaysThrowsException() {
        FineCalculator calculator = new FineCalculator();
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateFine(-3);
        });
    }
}
