// SecureRandom created with predictable seed and used for random data operation should be flagged as insecure.
package scensct.var.pos;

import java.security.SecureRandom;

public class PosCase1_Var2 {
    public static void main(String[] args) {
        // Variant 2: Intra-procedural refactoring with control flow
        SecureRandom sr = null;
        if (true) { // always true condition
            sr = new SecureRandom();
            sr.setSeed(98765L);
        }
        // The random operation is outside the if block but still reachable
        int randomValue = sr.nextInt(); // [REPORTED LINE]
    }
}