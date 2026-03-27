// Non-RSA cryptographic algorithm specification should not be flagged as RSA cipher without OAEP
package scensct.var.neg;

import javax.crypto.Cipher;

public class NegCase2_Var1 {
    public static void main(String[] args) throws Exception {
        // Variant 1: String built via concatenation of parts
        final String mode = "/GCM/NoPadding";
        String algorithm = "AES" + mode;
        Cipher cipher = Cipher.getInstance(algorithm);
    }
}