// Insecure randomness flows to non-sensitive sink should not be flagged as insecure randomness usage.
package scensct.var.neg;

import java.util.Random;

public class NegCase5_Var2 {
    // Variant 2: Extract random generation to a helper method.
    private static int getInsecureRandom() {
        return new Random().nextInt();
    }
    
    public static void main(String[] args) {
        int num = getInsecureRandom();
        // Non-sensitive sink with different formatting.
        System.err.printf("Debug: %d%n", num);
    }
}