// SecureRandom created with predictable seed, possibly additional setSeed calls, used for random data with other operations allowed after prior operations should be flagged as insecure.
package scensct.var.pos;

import java.security.SecureRandom;

public class PosCase5_Var4 {
    public static void main(String[] args) {
        // Variant 4: Use try-catch-finally, seeding in try block
        SecureRandom sr = new SecureRandom();
        try {
            sr.setSeed(33333L);
        } finally {
            sr.setSeed(44444L);
        }
        int first = sr.nextInt(); // Should report // [REPORTED LINE]
        int second = sr.nextInt(); // Should report // [REPORTED LINE]
    }
}