// Predictable seed exists but not connected to the SecureRandom usage should not be flagged.
package scensct.var.neg;

import java.security.SecureRandom;

public class NegCase2_Var5 {
    // Variant 5: Loop structure that obscures but preserves the invariant
    public static void main(String[] args) {
        SecureRandom[] randoms = new SecureRandom[2];
        randoms[0] = new SecureRandom(new byte[]{1, 2, 3});
        randoms[1] = new SecureRandom();
        int randomValue = 0;
        for (int i = 0; i < randoms.length; i++) {
            if (i == 1) { // only the unseeded one is used
                randomValue = randoms[i].nextInt();
            }
        }
        System.out.println(randomValue);
    }
}