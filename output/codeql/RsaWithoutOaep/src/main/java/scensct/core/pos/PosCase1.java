// RSA algorithm string without OAEP flows to getAlgoSpec() should be flagged as Positive.
package scensct.core.pos;

import javax.crypto.Cipher;

public class PosCase1 {
    public static void main(String[] args) throws Exception {
        // Source: compile-time constant RSA string without OAEP
        String algo = "RSA/ECB/PKCS1Padding"; // [REPORTED LINE]
        // Flow to cryptographic algorithm specification parameter
        Cipher cipher = Cipher.getInstance(algo);
    }
}