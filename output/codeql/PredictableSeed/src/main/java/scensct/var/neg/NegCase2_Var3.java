// Predictable seed exists but not connected to the SecureRandom usage should not be flagged.
package scensct.var.neg;

import java.security.SecureRandom;

public class NegCase2_Var3 {
    public static void main(String[] args) {
        // Variant 3: Control flow with conditional that always takes the unseeded branch
        SecureRandom sr1 = new SecureRandom(new byte[]{1, 2, 3});
        SecureRandom sr2 = new SecureRandom();
        SecureRandom target = args.length > 1000 ? sr1 : sr2; // always sr2 in practice
        int randomValue = target.nextInt();
        System.out.println(randomValue);
    }
}