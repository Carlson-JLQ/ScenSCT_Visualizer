// Predictable seed exists but not connected to the SecureRandom usage should not be flagged.
package scensct.core.neg;

import java.security.SecureRandom;

public class NegCase2 {
    public static void main(String[] args) {
        // Scenario 2: Predictable seed elsewhere, not associated with this usage variable
        SecureRandom sr1 = new SecureRandom(new byte[]{1, 2, 3}); // Predictable seed for sr1
        SecureRandom sr2 = new SecureRandom(); // No seed for sr2
        int randomValue = sr2.nextInt(); // GetRandomData on sr2, not sr1
        System.out.println(randomValue);
    }
}