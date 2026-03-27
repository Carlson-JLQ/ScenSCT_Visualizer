// SecureRandom seeded with non-predictable argument should not be flagged as predictably seeded.
package scensct.var.neg;

import java.security.SecureRandom;

public class NegCase3_Var3 {
    // Variant 3: Seed generation and seeding extracted into separate methods,
    // with the SecureRandom instance passed as argument
    private static void seedRandom(SecureRandom target, long seed) {
        target.setSeed(seed);
    }

    public static void main(String[] args) {
        SecureRandom seedGenerator = new SecureRandom();
        long nonPredictable = seedGenerator.nextLong();
        SecureRandom userRandom = new SecureRandom();
        seedRandom(userRandom, nonPredictable);
        System.out.println(userRandom.nextInt());
    }
}