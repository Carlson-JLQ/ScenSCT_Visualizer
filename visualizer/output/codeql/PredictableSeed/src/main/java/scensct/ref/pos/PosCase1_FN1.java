// SecureRandom created with predictable seed and used for random data operation should be flagged as insecure.
package scensct.ref.pos;

import java.security.SecureRandom;

public class PosCase1_FN1 {
    public static void main(String[] args) {
        // Scenario 1: Constructor with predictable seed, then used for random data
        SecureRandom sr = new SecureRandom("predictableSeed".getBytes());
        int randomValue = sr.nextInt(); // Random data operation
    }
}