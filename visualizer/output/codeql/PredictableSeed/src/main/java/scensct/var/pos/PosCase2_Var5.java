// SecureRandom seeded via setSeed with predictable value and used for random data operation should be flagged as insecure.
package scensct.var.pos;

import java.security.SecureRandom;

public class PosCase2_Var5 {
    // Variant 5: Idiomatic variation — use constructor with seed material, but still call setSeed predictably
    public static void main(String[] args) {
        byte[] dummy = new byte[1];
        SecureRandom sr = new SecureRandom(dummy); // constructor with seed material
        sr.setSeed(55555L); // Override with predictable seed
        int rnd = sr.nextInt(); // Random data operation
    }
}