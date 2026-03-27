// Non-RSA cryptographic algorithm specification should not be flagged as RSA cipher without OAEP
package scensct.var.neg;

import javax.crypto.Cipher;

public class NegCase2_Var2 {
    // Variant 2: Algorithm string from a static helper method
    private static String getAlgorithm() {
        return "AES/GCM/NoPadding";
    }
    
    public static void main(String[] args) throws Exception {
        Cipher cipher = Cipher.getInstance(getAlgorithm());
    }
}