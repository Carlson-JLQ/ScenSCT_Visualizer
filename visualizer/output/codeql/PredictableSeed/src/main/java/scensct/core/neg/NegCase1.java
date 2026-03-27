// SecureRandom seeded with non-predictable source should not be flagged as predictably seeded.
package scensct.core.neg;

import java.security.SecureRandom;

public class NegCase1 {
    public static void main(String[] args) {
        // Scenario 1: No predictable seed in any dataflow path to usage
        SecureRandom sr = new SecureRandom(); // Constructor without seed argument
        int randomValue = sr.nextInt(); // GetRandomData operation
        System.out.println(randomValue);
    }
}