// SecureRandom seeded via setSeed with predictable value and used for random data operation should be flagged as insecure.
package scensct.var.pos;

import java.security.SecureRandom;

public class PosCase2_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring — split declaration and assignment, rename, change literal format
        SecureRandom randomGen;
        randomGen = new SecureRandom();
        long predictableSeed = 0xD903L; // hex literal for 55555 decimal
        randomGen.setSeed(predictableSeed);
        int val = randomGen.nextInt(); // Random data operation // [REPORTED LINE]
    }
}