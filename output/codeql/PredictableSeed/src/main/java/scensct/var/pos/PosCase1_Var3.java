// SecureRandom created with predictable seed and used for random data operation should be flagged as insecure.
package scensct.var.pos;

import java.security.SecureRandom;

public class PosCase1_Var3 {
    // Variant 3: Inter-procedural refactoring - helper method for seeding
    private static void seedRandom(SecureRandom rng) {
        rng.setSeed(98765L);
    }
    
    public static void main(String[] args) {
        SecureRandom sr = new SecureRandom();
        seedRandom(sr);
        int randomValue = sr.nextInt();
    }
}