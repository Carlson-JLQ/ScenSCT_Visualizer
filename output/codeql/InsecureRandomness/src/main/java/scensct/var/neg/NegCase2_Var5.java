// SecureRandom usage should not be flagged as insecure randomness usage.
package scensct.var.neg;

import java.security.SecureRandom;

public class NegCase2_Var5 {
    public static void main(String[] args) throws Exception {
        // Variant 5: SecureRandom via getInstance, with try-catch noise
        SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
        int secureVal;
        try {
            secureVal = sr.nextInt();
        } finally {
            // just noise
        }
        System.out.println(secureVal);
    }
}