// SecureRandom created with predictable seed, possibly additional setSeed calls, used for random data with other operations allowed after prior operations should be flagged as insecure.
package scensct.var.pos;

import java.security.SecureRandom;

public class PosCase5_Var1 {
    public static void main(String[] args) {
        // Variant 1: Control flow with constant condition, seeding inside block
        SecureRandom rng = new SecureRandom();
        if (true) {
            rng.setSeed(33333L);
        }
        rng.setSeed(44444L);
        int val1 = rng.nextInt(); // Should report // [REPORTED LINE]
        int val2 = rng.nextInt(); // Should report // [REPORTED LINE]
    }
}