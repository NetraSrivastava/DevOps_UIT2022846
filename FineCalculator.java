public class FineCalculator {

    private static final int FINE_PER_DAY = 5;

    /**
     * Calculates fine based on number of late days.
     * @param lateDays number of days book is returned late
     * @return total fine amount
     * @throws IllegalArgumentException if lateDays is negative
     */
    public int calculateFine(int lateDays) {
        if (lateDays < 0) {
            throw new IllegalArgumentException("Late days cannot be negative");
        }

        return lateDays * FINE_PER_DAY;
    }
}