// Non-compile-time constant string flowing to algorithm parameter should not be flagged
package scensct.var.neg;

import javax.crypto.Cipher;

public class NegCase3_Var1 {
    public static void main(String[] args) throws Exception {
        // Variant 1: Build string via concatenation of compile-time constant parts
        String base = "RSA/ECB/OAEPWith";
        String suffix = "SHA-256AndMGF1Padding";
        String alg = base + suffix; // Non-constant due to concatenation
        Cipher cipher = Cipher.getInstance(alg);
    }
    
    private static String getAlgorithm() {
        return "unused"; // Original method kept but not used
    }
}