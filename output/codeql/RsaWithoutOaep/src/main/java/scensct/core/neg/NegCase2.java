// Non-RSA cryptographic algorithm specification should not be flagged as RSA cipher without OAEP
package scensct.core.neg;

import javax.crypto.Cipher;

public class NegCase2 {
    public static void main(String[] args) throws Exception {
        // Source: compile-time constant non-RSA algorithm string
        final String ALG = "AES/GCM/NoPadding";
        // Flow to cryptographic algorithm specification parameter
        Cipher cipher = Cipher.getInstance(ALG);
    }
}