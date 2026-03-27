// SecureRandom seeded with non-predictable source should not be flagged as predictably seeded.
package scensct.var.neg;

import java.security.SecureRandom;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring with temporary variable and renamed identifiers
        SecureRandom randomGenerator = new SecureRandom();
        int generatedRandom = randomGenerator.nextInt();
        System.out.println("Random: " + generatedRandom);
    }
}