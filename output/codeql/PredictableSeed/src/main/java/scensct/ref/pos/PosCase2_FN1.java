// SecureRandom seeded via setSeed with predictable value and used for random data operation should be flagged as insecure.
package scensct.ref.pos;

import java.security.SecureRandom;

public class PosCase2_FN1 {
    public static void main(String[] args) {
        // Scenario 2: Instance created, seeded via setSeed with predictable value, then used
        SecureRandom sr = new SecureRandom();
        sr.setSeed("predictableSeed".getBytes()); // Predictable seed via setSeed
        int randomValue = sr.nextInt(); // Random data operation
    }
}