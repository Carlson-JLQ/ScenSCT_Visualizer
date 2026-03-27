// SecureRandom usage should not be flagged as insecure randomness usage.
package scensct.core.neg;

import java.security.SecureRandom;

public class NegCase2 {
    public static void main(String[] args) {
        // Secure random source, not insecure.
        SecureRandom sr = new SecureRandom();
        int secureNum = sr.nextInt();
        System.out.println(secureNum);
    }
}