// SecureRandom created with predictable seed, possibly additional setSeed calls, used for random data while other instances exist should be flagged as insecure.
package scensct.var.pos;

import java.security.SecureRandom;

public class PosCase3_Var1 {
    public static void main(String[] args) {
        // Variant 1: Use constructor with seed, then additional setSeed, restructure control flow
        SecureRandom random = new SecureRandom(new byte[] {0x01, 0x02}); // Predictable seed via constructor
        random.setSeed(33333L); // Additional predictable seed
        if (args.length > -1) { // Always true, but adds branching
            int value = random.nextInt(); // Random data operation // [REPORTED LINE]
        }
        
        // Different instance created in a loop
        SecureRandom other = null;
        for (int i = 0; i < 1; i++) {
            other = new SecureRandom();
        }
        int val = other.nextInt();
    }
}