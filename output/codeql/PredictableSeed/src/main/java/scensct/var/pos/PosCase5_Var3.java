// SecureRandom created with predictable seed, possibly additional setSeed calls, used for random data with other operations allowed after prior operations should be flagged as insecure.
package scensct.var.pos;

import java.security.SecureRandom;

public class PosCase5_Var3 {
    // Variant 3: Inline a method that returns seeded SecureRandom
    private static SecureRandom makeSeeded() {
        SecureRandom sr = new SecureRandom();
        sr.setSeed(33333L);
        sr.setSeed(44444L);
        return sr;
    }
    
    public static void main(String[] args) {
        SecureRandom sr = makeSeeded();
        int x = sr.nextInt(); // Should report
        int y = sr.nextInt(); // Should report
    }
}