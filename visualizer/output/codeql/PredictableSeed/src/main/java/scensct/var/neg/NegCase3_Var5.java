// SecureRandom seeded with non-predictable argument should not be flagged as predictably seeded.
package scensct.var.neg;

import java.security.SecureRandom;

public class NegCase3_Var5 {
    public static void main(String[] args) {
        // Variant 5: Seed stored in a boxed Long, control flow with loop
        SecureRandom seedSource = new SecureRandom();
        Long boxedSeed = Long.valueOf(seedSource.nextLong());
        SecureRandom random = new SecureRandom();
        for (int i = 0; i < 1; i++) { // single iteration loop
            random.setSeed(boxedSeed);
        }
        int result = random.nextInt();
        System.out.println(result);
    }
}