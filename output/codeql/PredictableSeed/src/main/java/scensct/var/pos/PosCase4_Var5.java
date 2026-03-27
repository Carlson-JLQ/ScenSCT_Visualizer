// SecureRandom seeded exactly once via setSeed with predictable value and used for random data operation should be flagged as insecure.
package scensct.var.pos;

import java.security.SecureRandom;

public class PosCase4_Var5 {
    public static void main(String[] args) {
        SecureRandom sr = new SecureRandom();
        byte[] seedBytes = new byte[] { 0, 0, 0, 0, 0, 0, 48, 57 }; // 12345 in big-endian
        sr.setSeed(seedBytes);
        sr.nextInt(); // [REPORTED LINE]
    }
}