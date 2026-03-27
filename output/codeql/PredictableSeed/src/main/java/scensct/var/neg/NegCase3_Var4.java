// SecureRandom seeded with non-predictable argument should not be flagged as predictably seeded.
package scensct.var.neg;

import java.security.SecureRandom;

public class NegCase3_Var4 {
    public static void main(String[] args) {
        // Variant 4: Use SecureRandom.generateSeed to obtain seed bytes, then convert to long
        SecureRandom seedGen = new SecureRandom();
        byte[] seedBytes = seedGen.generateSeed(8); // 8 bytes for a long
        long seed = 0;
        for (int i = 0; i < 8; i++) {
            seed = (seed << 8) | (seedBytes[i] & 0xFF);
        }
        SecureRandom sr = new SecureRandom();
        sr.setSeed(seed);
        System.out.println(sr.nextInt()); // [REPORTED LINE]
    }
}