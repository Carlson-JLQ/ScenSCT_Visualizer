// Non-compile-time constant string flowing to algorithm parameter should not be flagged
package scensct.core.neg;

import javax.crypto.Cipher;

public class NegCase3 {
    public static void main(String[] args) throws Exception {
        // Source: non-compile-time constant string (method return)
        String alg = getAlgorithm();
        // Flow to cryptographic algorithm specification parameter
        Cipher cipher = Cipher.getInstance(alg);
    }
    
    private static String getAlgorithm() {
        return "RSA/ECB/OAEPWithSHA-256AndMGF1Padding"; // Non-constant from checker's perspective // [REPORTED LINE]
    }
}