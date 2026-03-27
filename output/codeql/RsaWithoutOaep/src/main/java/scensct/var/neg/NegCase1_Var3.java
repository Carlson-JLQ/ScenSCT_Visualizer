// RSA algorithm specification containing OAEP should not be flagged as non-OAEP RSA cipher
package scensct.var.neg;

import javax.crypto.Cipher;

public class NegCase1_Var3 {
    public static void main(String[] args) throws Exception {
        final String baseAlg = "RSA/ECB/OAEPWithSHA-1AndMGF1Padding";
        String chosenAlg;
        
        // Control flow that always selects the OAEP variant
        if (System.currentTimeMillis() > 0) { // Always true
            chosenAlg = baseAlg;
        } else {
            chosenAlg = "AES/CBC/PKCS5Padding"; // Dead code
        }
        
        Cipher cipher = Cipher.getInstance(chosenAlg);
    }
}