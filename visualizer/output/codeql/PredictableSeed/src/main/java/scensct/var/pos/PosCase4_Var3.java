// SecureRandom seeded exactly once via setSeed with predictable value and used for random data operation should be flagged as insecure.
package scensct.var.pos;

import java.security.SecureRandom;

public class PosCase4_Var3 {
    public static void main(String[] args) {
        SecureRandom sr = new SecureRandom();
        if (args.length >= 0) { // always true
            sr.setSeed(12345L);
        }
        sr.nextInt(); // [REPORTED LINE]
    }
}