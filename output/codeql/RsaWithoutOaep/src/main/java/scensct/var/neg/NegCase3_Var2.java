// Non-compile-time constant string flowing to algorithm parameter should not be flagged
package scensct.var.neg;

import javax.crypto.Cipher;

public class NegCase3_Var2 {
    public static void main(String[] args) throws Exception {
        // Variant 2: Extract algorithm via helper method with conditional logic
        String alg = deriveAlgorithm(true);
        Cipher cipher = Cipher.getInstance(alg);
    }
    
    private static String deriveAlgorithm(boolean useOAEP) {
        if (useOAEP) {
            return "RSA/ECB/OAEPWithSHA-256AndMGF1Padding";
        } else {
            return "RSA/ECB/PKCS1Padding"; // [REPORTED LINE]
        }
    }
}