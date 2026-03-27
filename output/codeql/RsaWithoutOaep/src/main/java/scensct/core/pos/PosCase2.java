// Final variable holding RSA algorithm without OAEP flows to getAlgoSpec() should be flagged as Positive.
package scensct.core.pos;

import javax.crypto.Cipher;

public class PosCase2 {
    public static void main(String[] args) throws Exception {
        // Source: final variable (compile-time constant) with RSA string without OAEP
        final String RSA_ALGO = "RSA/ECB/PKCS1Padding"; // [REPORTED LINE]
        // Flow to cryptographic algorithm specification parameter (checker sees literal value)
        Cipher cipher = Cipher.getInstance(RSA_ALGO); // [REPORTED LINE]
    }
}