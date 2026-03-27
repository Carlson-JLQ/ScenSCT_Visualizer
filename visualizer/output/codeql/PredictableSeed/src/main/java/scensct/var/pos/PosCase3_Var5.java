// SecureRandom created with predictable seed, possibly additional setSeed calls, used for random data while other instances exist should be flagged as insecure.
package scensct.var.pos;

import java.security.SecureRandom;

public class PosCase3_Var5 {
    public static void main(String[] args) {
        // Variant 5: Nest seeding inside a conditional that always executes, use temporary variable for instance
        SecureRandom target;
        target = new SecureRandom();
        boolean flag = true;
        if (flag) {
            target.setSeed(101010L); // Predictable seed
            target.setSeed(202020L); // Additional seed
        }
        int randomValue = target.nextInt(); // Random data operation // [REPORTED LINE]
        
        // Different instance as a field-like local, but not seeded
        SecureRandom other = new SecureRandom();
        other.nextInt();
    }
}