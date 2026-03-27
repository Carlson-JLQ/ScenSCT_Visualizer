// SecureRandom seeded with non-predictable source should not be flagged as predictably seeded.
package scensct.var.neg;

import java.security.SecureRandom;

public class NegCase1_Var5 {
    // Variant 5: Inlining and expression rewrite, using a static initializer block for setup
    private static SecureRandom staticRandom;
    
    static {
        staticRandom = new SecureRandom();
    }
    
    public static void main(String[] args) {
        int randomValue = staticRandom.nextInt();
        System.out.println("Static random: " + randomValue);
    }
}