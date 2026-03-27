// Predictable seed exists but not connected to the SecureRandom usage should not be flagged.
package scensct.var.neg;

import java.security.SecureRandom;

public class NegCase2_Var4 {
    // Variant 4: Inline the seeded creation into a dead assignment, keep usage separate
    public static void main(String[] args) {
        SecureRandom sr2 = new SecureRandom();
        // seeded instance created but immediately overshadowed
        SecureRandom sr1 = new SecureRandom(new byte[]{1, 2, 3});
        sr1 = sr2; // sr1 now refers to the unseeded instance
        int randomValue = sr1.nextInt(); // actually using sr2 via sr1 alias
        System.out.println(randomValue);
    }
}