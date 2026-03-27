// SecureRandom created with predictable seed, possibly additional setSeed calls, used for random data while other instances exist should be flagged as insecure.
package scensct.var.pos;

import java.security.SecureRandom;

public class PosCase3_Var2 {
    private static void useRandom(SecureRandom r) {
        int v = r.nextInt(); // Random data operation
    }
    
    public static void main(String[] args) {
        // Variant 2: Extract seeding and usage into separate steps with helper method
        SecureRandom sr = new SecureRandom();
        long seed = 44444L; // Predictable seed value in variable
        sr.setSeed(seed);
        sr.setSeed(55555L); // Additional seed
        useRandom(sr); // Usage via method call
        
        // Different instance created and used inline
        new SecureRandom().nextInt();
    }
}