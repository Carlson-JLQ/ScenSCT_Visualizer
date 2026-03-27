// Predictable seed exists but not connected to the SecureRandom usage should not be flagged.
package scensct.var.neg;

import java.security.SecureRandom;

public class NegCase2_Var2 {
    // Variant 2: Extract seeded instance creation to a helper method
    private static SecureRandom createSeeded() {
        return new SecureRandom(new byte[]{1, 2, 3});
    }

    public static void main(String[] args) {
        SecureRandom sr1 = createSeeded(); // seeded, but unused for random data
        SecureRandom sr2 = new SecureRandom();
        int randomValue = sr2.nextInt();
        System.out.println(randomValue);
    }
}