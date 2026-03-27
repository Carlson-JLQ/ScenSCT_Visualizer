// Predictable seed exists but not connected to the SecureRandom usage should not be flagged.
package scensct.var.neg;

import java.security.SecureRandom;

public class NegCase2_Var1 {
    public static void main(String[] args) {
        // Variant 1: Swap declaration order and introduce a temporary alias
        SecureRandom sr2 = new SecureRandom();
        byte[] seed = {1, 2, 3};
        SecureRandom sr1 = new SecureRandom(seed);
        SecureRandom usedRandom = sr2; // alias to the unseeded instance
        int randomValue = usedRandom.nextInt();
        System.out.println(randomValue);
    }
}