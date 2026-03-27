// SecureRandom seeded with non-predictable argument should not be flagged as predictably seeded.
package scensct.core.neg;

import java.security.SecureRandom;

public class NegCase3 {
    public static void main(String[] args) {
        // Scenario 3: Seed argument derived from non-predictable source
        SecureRandom seedGen = new SecureRandom();
        long nonPredictableSeed = seedGen.nextLong(); // Truly non-predictable source
        SecureRandom sr = new SecureRandom();
        sr.setSeed(nonPredictableSeed); // Seed argument not from predictable expression
        int randomValue = sr.nextInt(); // GetRandomData operation
        System.out.println(randomValue);
    }
}