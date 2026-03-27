// SecureRandom seeded with non-predictable source should not be flagged as predictably seeded.
package scensct.var.neg;

import java.security.SecureRandom;

public class NegCase1_Var2 {
    // Variant 2: Inter-procedural refactoring - extraction of SecureRandom usage to a helper method
    private static int obtainRandomValue() {
        SecureRandom sr = new SecureRandom();
        return sr.nextInt();
    }
    
    public static void main(String[] args) {
        int val = obtainRandomValue();
        System.out.println(val);
    }
}