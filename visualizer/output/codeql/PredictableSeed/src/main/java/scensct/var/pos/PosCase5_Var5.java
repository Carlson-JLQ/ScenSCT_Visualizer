// SecureRandom created with predictable seed, possibly additional setSeed calls, used for random data with other operations allowed after prior operations should be flagged as insecure.
package scensct.var.pos;

import java.security.SecureRandom;

public class PosCase5_Var5 {
    public static void main(String[] args) {
        // Variant 5: Aliasing and temporary variable, reordered but seed before use
        SecureRandom sr1 = new SecureRandom();
        SecureRandom sr2 = sr1; // Alias
        sr2.setSeed(33333L);
        sr1.setSeed(44444L);
        int r1 = sr2.nextInt(); // Should report // [REPORTED LINE]
        int r2 = sr1.nextInt(); // Should report // [REPORTED LINE]
    }
}