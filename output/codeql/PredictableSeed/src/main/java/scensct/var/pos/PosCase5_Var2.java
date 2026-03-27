// SecureRandom created with predictable seed, possibly additional setSeed calls, used for random data with other operations allowed after prior operations should be flagged as insecure.
package scensct.var.pos;

import java.security.SecureRandom;

public class PosCase5_Var2 {
    // Variant 2: Extract seeding to a helper method
    private static void seedPredictably(SecureRandom sr) {
        sr.setSeed(33333L);
        sr.setSeed(44444L);
    }
    
    public static void main(String[] args) {
        SecureRandom sr = new SecureRandom();
        seedPredictably(sr);
        int a = sr.nextInt(); // Should report
        int b = sr.nextInt(); // Should report
    }
}