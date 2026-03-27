// Non-compile-time constant string flowing to algorithm parameter should not be flagged
package scensct.var.neg;

import javax.crypto.Cipher;

public class NegCase3_Var3 {
    public static void main(String[] args) throws Exception {
        // Variant 3: Algorithm string built via StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("RSA/ECB/");
        sb.append("OAEPWithSHA-256AndMGF1Padding");
        String alg = sb.toString();
        Cipher cipher = Cipher.getInstance(alg);
    }
    
    private static String getAlgorithm() {
        return null; // Original method changed
    }
}