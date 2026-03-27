// SecureRandom seeded via setSeed with predictable value and used for random data operation should be flagged as insecure.
package scensct.var.pos;

import java.security.SecureRandom;

public class PosCase2_Var3 {
    // Variant 3: Inter-procedural — extract seeding to a helper method
    private static void seedPredictably(SecureRandom rng) {
        rng.setSeed(55555L);
    }
    
    public static void main(String[] args) {
        SecureRandom sr = new SecureRandom();
        seedPredictably(sr);
        int x = sr.nextInt(); // Random data operation
    }
}