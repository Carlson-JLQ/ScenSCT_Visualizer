// SecureRandom seeded with non-predictable argument should not be flagged as predictably seeded.
package scensct.ref.neg;

import java.security.SecureRandom;

public class NegCase3_FP1 {
    public static void main(String[] args) {
        // Scenario 3: Seed argument derived from non-predictable source
        long nonPredictableSeed = System.currentTimeMillis(); // Non-constant source
        SecureRandom sr = new SecureRandom();
        sr.setSeed(nonPredictableSeed); // Seed argument not from predictable expression
        int randomValue = sr.nextInt(); // GetRandomData operation // [REPORTED LINE]
        System.out.println(randomValue);
    }
}