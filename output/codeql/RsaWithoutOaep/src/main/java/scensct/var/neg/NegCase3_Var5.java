// Non-compile-time constant string flowing to algorithm parameter should not be flagged
package scensct.var.neg;

import javax.crypto.Cipher;

public class NegCase3_Var5 {
    public static void main(String[] args) throws Exception {
        // Variant 5: String with OAEP embedded via replace operation
        String template = "RSA/ECB/XOAEPXWithSHA-256AndMGF1Padding";
        String alg = template.replace("XOAEPX", "OAEP"); // Results in OAEP-containing string
        Cipher cipher = Cipher.getInstance(alg);
    }
    
    private static String getAlgorithm() {
        return "dummy";
    }
}