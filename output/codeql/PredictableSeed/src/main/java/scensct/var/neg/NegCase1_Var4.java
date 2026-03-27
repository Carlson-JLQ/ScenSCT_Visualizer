// SecureRandom seeded with non-predictable source should not be flagged as predictably seeded.
package scensct.var.neg;

import java.security.SecureRandom;

public class NegCase1_Var4 {
    public static void main(String[] args) {
        // Variant 4: Using try-with-resources (SecureRandom is not AutoCloseable, so simulate with try-catch-finally)
        SecureRandom sr = new SecureRandom();
        try {
            int randomValue = sr.nextInt();
            System.out.println(randomValue);
        } catch (Exception e) {
            // Ignore, but no seed introduced
        } finally {
            // Cleanup simulation
            sr = null;
        }
    }
}