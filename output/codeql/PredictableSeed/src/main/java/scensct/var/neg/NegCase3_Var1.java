// SecureRandom seeded with non-predictable argument should not be flagged as predictably seeded.
package scensct.var.neg;

import java.security.SecureRandom;

public class NegCase3_Var1 {
    public static void main(String[] args) {
        // Variant 1: Seed passed through a temporary variable and a conditional branch
        SecureRandom seedSrc = new SecureRandom();
        long seed = seedSrc.nextLong();
        boolean flag = (System.currentTimeMillis() % 2 == 0);
        long seedToUse;
        if (flag) {
            seedToUse = seed;
        } else {
            seedToUse = seed;
        }
        SecureRandom rand = new SecureRandom();
        rand.setSeed(seedToUse);
        System.out.println(rand.nextInt());
    }
}