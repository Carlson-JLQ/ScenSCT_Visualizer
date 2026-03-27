// SecureRandom seeded with both predictable and non-predictable seeds should not be flagged.
package scensct.core.neg;

import java.security.SecureRandom;

public class NegCase4 {
    public static void main(String[] args) {
        // Scenario 4: Both predictable and non-predictable seeds in dataflow path
        SecureRandom sr = new SecureRandom();
        sr.setSeed(System.nanoTime()); // Non-predictable seed first
        sr.setSeed(12345L); // Predictable seed after non-predictable one
        int randomValue = sr.nextInt(); // GetRandomData operation // [REPORTED LINE]
        System.out.println(randomValue);
    }
}