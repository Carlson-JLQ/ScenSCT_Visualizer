// SecureRandom usage should not be flagged as insecure randomness usage.
package scensct.var.neg;

import java.security.SecureRandom;

public class NegCase2_Var2 {
    private static int generateSecureNumber() {
        SecureRandom sr = new SecureRandom();
        return sr.nextInt();
    }

    public static void main(String[] args) {
        // Variant 2: Secure random generation extracted to helper method
        int secureNum = generateSecureNumber();
        System.out.println(secureNum);
    }
}