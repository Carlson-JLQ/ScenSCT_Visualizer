// Final variable holding RSA algorithm without OAEP flows to getAlgoSpec() should be flagged as Positive.
package scensct.var.pos;

import javax.crypto.Cipher;

public class PosCase2_Var5 {
    // Variant 5: Aliasing through local variable with try-catch (preserving flow)
    public static void main(String[] args) throws Exception {
        final String original = "RSA/ECB/PKCS1Padding"; // [REPORTED LINE]
        String algorithm = original; // [REPORTED LINE]
        try {
            Cipher cipher = Cipher.getInstance(algorithm);
        } catch (Exception e) {
            throw e;
        }
    }
}