// SecureRandom usage should not be flagged as insecure randomness usage.
package scensct.var.neg;

import java.security.SecureRandom;

public class NegCase2_Var1 {
    public static void main(String[] args) {
        // Variant 1: SecureRandom via different constructor and method
        SecureRandom secureRng = new SecureRandom(new byte[]{1, 2, 3});
        int val = secureRng.nextInt(Integer.MAX_VALUE);
        System.out.println("Secure random: " + val);
    }
}