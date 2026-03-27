// Final variable holding RSA algorithm without OAEP flows to getAlgoSpec() should be flagged as Positive.
package scensct.var.pos;

import javax.crypto.Cipher;

public class PosCase2_Var3 {
    // Variant 3: Intra-procedural refactoring - control flow with constant propagation
    public static void main(String[] args) throws Exception {
        final String algo;
        if (System.currentTimeMillis() > 0) { // Always true, but opaque to checker
            algo = "RSA/ECB/PKCS1Padding"; // [REPORTED LINE]
        } else {
            algo = "AES";
        }
        Cipher cipher = Cipher.getInstance(algo);
    }
}