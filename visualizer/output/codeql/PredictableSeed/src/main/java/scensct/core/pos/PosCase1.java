// SecureRandom created with predictable seed and used for random data operation should be flagged as insecure.
package scensct.core.pos;

import java.security.SecureRandom;

public class PosCase1 {
    public static void main(String[] args) {
        // Scenario 1: Constructor with predictable seed, then used for random data
        SecureRandom sr = new SecureRandom();
        sr.setSeed(98765L); // Predictable seed via setSeed
        int randomValue = sr.nextInt(); // Random data operation // [REPORTED LINE]
    }
}