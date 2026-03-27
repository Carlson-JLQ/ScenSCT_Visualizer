// SecureRandom created with predictable seed and used for random data operation should be flagged as insecure.
package scensct.var.pos;

import java.security.SecureRandom;

public class PosCase1_Var5 {
    // Variant 5: Complex intra-procedural with try-catch and alias
    public static void main(String[] args) {
        SecureRandom sr = new SecureRandom();
        SecureRandom alias = sr;
        try {
            alias.setSeed(98765L);
        } catch (Exception e) {
            // ignore, won't happen
        } finally {
            // The seed is already set
        }
        int randomValue = alias.nextInt(); // [REPORTED LINE]
    }
}