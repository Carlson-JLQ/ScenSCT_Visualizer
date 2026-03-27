// SecureRandom created with predictable seed, possibly additional setSeed calls, used for random data while other instances exist should be flagged as insecure.
package scensct.ref.pos;

import java.security.SecureRandom;

public class PosCase3_FN1 {
    public static void main(String[] args) {
        // Scenario 3: Constructor with predictable seed, additional setSeed, used for random data
        SecureRandom sr1 = new SecureRandom("seed1".getBytes());
        sr1.setSeed("additionalSeed".getBytes()); // Additional predictable seed
        int val1 = sr1.nextInt(); // Random data operation on sr1
        
        // Different SecureRandom instance for other random data operations
        SecureRandom sr2 = new SecureRandom();
        int val2 = sr2.nextInt(); // Operation on different instance
    }
}