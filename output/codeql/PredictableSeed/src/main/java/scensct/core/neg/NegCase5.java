// Predictable seed consumed by intermediate GetRandomData should not flag later usage.
package scensct.core.neg;

import java.security.SecureRandom;

public class NegCase5 {
    public static void main(String[] args) {
        // Scenario 5: Predictable seed consumed before usage
        SecureRandom sr = new SecureRandom();
        sr.setSeed(42L); // Predictable seed
        sr.setSeed(System.nanoTime()); // Mix in non-predictable entropy before first nextInt
        int intermediate = sr.nextInt(); // GetRandomData consumes seed // [REPORTED LINE]
        SecureRandom alias = sr; // Alias variable
        int randomValue = alias.nextInt(); // GetRandomData on alias after consumption
        System.out.println(randomValue);
    }
}