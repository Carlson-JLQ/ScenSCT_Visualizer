// Non-RSA cryptographic algorithm specification should not be flagged as RSA cipher without OAEP
package scensct.var.neg;

import javax.crypto.Cipher;

public class NegCase2_Var5 {
    // Variant 5: Algorithm from a final field, with call in a try-catch block
    private static final String CIPHER_ALG = "AES/GCM/NoPadding";
    
    public static void main(String[] args) throws Exception {
        try {
            Cipher cipher = Cipher.getInstance(CIPHER_ALG);
        } catch (Exception e) {
            throw e;
        }
    }
}