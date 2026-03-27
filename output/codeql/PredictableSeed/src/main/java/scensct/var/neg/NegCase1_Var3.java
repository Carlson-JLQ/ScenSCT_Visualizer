// SecureRandom seeded with non-predictable source should not be flagged as predictably seeded.
package scensct.var.neg;

import java.security.SecureRandom;

public class NegCase1_Var3 {
    public static void main(String[] args) {
        // Variant 3: Control-flow restructuring with a loop that does not affect seeding
        SecureRandom sr = null;
        for (int i = 0; i < 1; i++) { // Loop executes exactly once
            sr = new SecureRandom();
        }
        if (sr != null) {
            int randomValue = sr.nextInt();
            System.out.println(randomValue);
        }
    }
}