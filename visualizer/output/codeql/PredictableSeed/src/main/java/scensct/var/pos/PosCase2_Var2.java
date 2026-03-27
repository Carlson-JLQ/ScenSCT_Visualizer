// SecureRandom seeded via setSeed with predictable value and used for random data operation should be flagged as insecure.
package scensct.var.pos;

import java.security.SecureRandom;

public class PosCase2_Var2 {
    // Variant 2: Intra-procedural — introduce alias via another reference, add trivial control flow
    public static void main(String[] args) {
        SecureRandom sr = new SecureRandom();
        SecureRandom alias = sr;
        if (true) { // always true guard
            alias.setSeed(55555L);
        }
        int r = alias.nextInt(); // Random data operation // [REPORTED LINE]
    }
}