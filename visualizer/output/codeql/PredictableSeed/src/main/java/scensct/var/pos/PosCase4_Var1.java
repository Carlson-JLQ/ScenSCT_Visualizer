// SecureRandom seeded exactly once via setSeed with predictable value and used for random data operation should be flagged as insecure.
package scensct.var.pos;

import java.security.SecureRandom;

public class PosCase4_Var1 {
    public static void main(String[] args) {
        SecureRandom rng = new SecureRandom();
        long predictableSeed = 12345L;
        rng.setSeed(predictableSeed);
        int val = rng.nextInt(); // [REPORTED LINE]
    }
}