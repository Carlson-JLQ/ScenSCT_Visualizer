// No insecure randomness source should not be flagged as insecure randomness usage.
package scensct.var.neg;

import java.security.SecureRandom;

public class NegCase1_Var1 {
    public static void main(String[] args) {
        // Using a secure random source, which should not be flagged as insecure.
        SecureRandom secureRng = new SecureRandom();
        int x = secureRng.nextInt(100); // Secure random generation
        System.out.println(x);
    }
}