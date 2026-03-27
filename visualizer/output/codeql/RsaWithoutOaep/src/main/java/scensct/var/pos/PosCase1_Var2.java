// RSA algorithm string without OAEP flows to getAlgoSpec() should be flagged as Positive.
package scensct.var.pos;

import javax.crypto.Cipher;

public class PosCase1_Var2 {
    public static void main(String[] args) throws Exception {
        // Variant 2: Conditional assignment that always picks the non-OAEP string
        String algo;
        if (System.currentTimeMillis() > 0) { // Always true
            algo = "RSA/ECB/PKCS1Padding"; // [REPORTED LINE]
        } else {
            algo = "RSA/ECB/OAEPWithSHA-256AndMGF1Padding"; // Dead code
        }
        Cipher cipher = Cipher.getInstance(algo);
    }
}