// SecureRandom seeded exactly once via setSeed with predictable value and used for random data operation should be flagged as insecure.
package scensct.core.pos;

import java.security.SecureRandom;

public class PosCase4 {
    public static void main(String[] args) {
        // Scenario 4: Seeded exactly once via setSeed with predictable value, then used
        SecureRandom sr = new SecureRandom();
        sr.setSeed(12345L); // Exactly one predictable seed
        int randomValue = sr.nextInt(); // Random data operation after seeding // [REPORTED LINE]
    }
}