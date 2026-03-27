// SecureRandom seeded with non-predictable argument should not be flagged as predictably seeded.
package scensct.var.neg;

import java.security.SecureRandom;

public class NegCase3_Var2 {
    // Variant 2: Helper method returns the non-predictable seed
    private static long obtainSeed() {
        SecureRandom internalGen = new SecureRandom();
        return internalGen.nextLong();
    }

    public static void main(String[] args) {
        long seed = obtainSeed();
        SecureRandom sr = new SecureRandom();
        sr.setSeed(seed);
        int val = sr.nextInt();
        System.out.println(val);
    }
}