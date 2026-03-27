// RSA algorithm specification containing OAEP should not be flagged as non-OAEP RSA cipher
package scensct.var.neg;

import javax.crypto.Cipher;

public class NegCase1_Var5 {
    private static String buildRSAPrefix() {
        return "RSA/ECB/";
    }
    
    private static String buildOAEPPadding() {
        return "OAEPWithSHA-1AndMGF1Padding";
    }
    
    private static String combineAlgorithm(String a, String b) {
        return a + b;
    }
    
    public static void main(String[] args) throws Exception {
        String algorithm = combineAlgorithm(buildRSAPrefix(), buildOAEPPadding());
        Cipher cipher = Cipher.getInstance(algorithm);
    }
}