// SecureRandom created with predictable seed, possibly additional setSeed calls, used for random data while other instances exist should be flagged as insecure.
package scensct.var.pos;

import java.security.SecureRandom;

public class PosCase3_Var4 {
    public static void main(String[] args) {
        // Variant 4: Use array of seeds and loop to set seeds, then use
        SecureRandom sr1 = new SecureRandom();
        long[] seeds = {88888L, 99999L};
        for (long s : seeds) {
            sr1.setSeed(s); // Predictable seeds in loop
        }
        int val1 = sr1.nextInt(); // Random data operation // [REPORTED LINE]
        
        // Different instance created via method return
        SecureRandom sr2 = getSecureRandom();
        int val2 = sr2.nextInt();
    }
    
    private static SecureRandom getSecureRandom() {
        return new SecureRandom();
    }
}