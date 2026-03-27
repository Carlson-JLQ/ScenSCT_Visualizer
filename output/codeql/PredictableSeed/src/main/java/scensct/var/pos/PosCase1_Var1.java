// SecureRandom created with predictable seed and used for random data operation should be flagged as insecure.
package scensct.var.pos;

import java.security.SecureRandom;

public class PosCase1_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring with different literal and variable names
        SecureRandom randomGen = new SecureRandom();
        long predictableSeed = 98765L;
        randomGen.setSeed(predictableSeed);
        int val = randomGen.nextInt(); // [REPORTED LINE]
    }
}