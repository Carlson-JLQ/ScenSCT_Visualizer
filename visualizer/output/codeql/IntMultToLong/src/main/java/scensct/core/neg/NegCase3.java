// Multiplication explicitly cast to wider integral type should not be flagged as implicit conversion overflow.
package scensct.core.neg;

public class NegCase3 {
    public static void main(String[] args) {
        int m = 1000;
        int n = 2000;
        long widened = (long) (m * n); // Scenario 3: Explicit cast to long, preventing implicit conversion detection
        System.out.println(widened);
    }
}