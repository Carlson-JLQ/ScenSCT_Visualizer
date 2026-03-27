// RSA algorithm specification containing OAEP should not be flagged as non-OAEP RSA cipher
package scensct.core.neg;

import javax.crypto.Cipher;

public class NegCase1 {
    public static void main(String[] args) throws Exception {
        // Source: compile-time constant RSA string with OAEP
        final String ALG = "RSA/ECB/OAEPWithSHA-1AndMGF1Padding";
        // Flow to cryptographic algorithm specification parameter
        Cipher cipher = Cipher.getInstance(ALG);
    }
}