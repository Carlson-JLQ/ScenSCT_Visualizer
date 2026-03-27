// SecureRandom created with predictable seed, possibly additional setSeed calls, used for random data while other instances exist should be flagged as insecure.
package scensct.core.pos;

import java.security.SecureRandom;

public class PosCase3 {
    public static void main(String[] args) {
        // Scenario 3: Constructor with predictable seed, additional setSeed, used for random data
        SecureRandom sr1 = new SecureRandom();
        sr1.setSeed(11111L); // Predictable seed
        sr1.setSeed(22222L); // Additional predictable seed
        int val1 = sr1.nextInt(); // Random data operation on sr1 // [REPORTED LINE]
        
        // Different SecureRandom instance for other random data operations
        SecureRandom sr2 = new SecureRandom();
        int val2 = sr2.nextInt(); // Operation on different instance
    }
}