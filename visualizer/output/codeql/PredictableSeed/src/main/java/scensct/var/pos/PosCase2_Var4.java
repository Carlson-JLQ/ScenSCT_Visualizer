// SecureRandom seeded via setSeed with predictable value and used for random data operation should be flagged as insecure.
package scensct.var.pos;

import java.security.SecureRandom;

public class PosCase2_Var4 {
    // Variant 4: Intra-procedural — use try-finally, but seeding before use in same basic flow
    public static void main(String[] args) {
        SecureRandom sr = new SecureRandom();
        try {
            sr.setSeed(55555L);
        } finally {
            // still seeded before this call
        }
        int randomValue = sr.nextInt(); // Random data operation // [REPORTED LINE]
    }
}