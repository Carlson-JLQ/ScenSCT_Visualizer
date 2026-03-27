// SecureRandom seeded exactly once via setSeed with predictable value and used for random data operation should be flagged as insecure.
package scensct.var.pos;

import java.security.SecureRandom;

public class PosCase4_Var2 {
    static void useRandom(SecureRandom sr) {
        int x = sr.nextInt();
    }
    
    public static void main(String[] args) {
        SecureRandom sr = new SecureRandom();
        sr.setSeed(0x3039L); // hex for 12345
        useRandom(sr);
    }
}