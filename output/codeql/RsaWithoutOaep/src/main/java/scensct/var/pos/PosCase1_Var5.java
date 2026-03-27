// RSA algorithm string without OAEP flows to getAlgoSpec() should be flagged as Positive.
package scensct.var.pos;

import javax.crypto.Cipher;

public class PosCase1_Var5 {
    public static void main(String[] args) throws Exception {
        // Variant 5: Try-catch block with flow preserved
        String algo = null;
        try {
            algo = "RSA/ECB/PKCS1Padding"; // [REPORTED LINE]
        } catch (Exception e) {
            // Never reached
            algo = "AES";
        } finally {
            // Ensure algo is set (though it always is)
            if (algo == null) {
                algo = "RSA/ECB/PKCS1Padding"; // [REPORTED LINE]
            }
        }
        Cipher cipher = Cipher.getInstance(algo);
    }
}