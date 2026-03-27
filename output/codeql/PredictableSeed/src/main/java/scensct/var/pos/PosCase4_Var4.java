// SecureRandom seeded exactly once via setSeed with predictable value and used for random data operation should be flagged as insecure.
package scensct.var.pos;

import java.security.SecureRandom;

public class PosCase4_Var4 {
    private static SecureRandom createAndSeed() {
        SecureRandom sr = new SecureRandom();
        sr.setSeed(12345L);
        return sr;
    }
    
    public static void main(String[] args) {
        SecureRandom random = createAndSeed();
        random.nextInt();
    }
}