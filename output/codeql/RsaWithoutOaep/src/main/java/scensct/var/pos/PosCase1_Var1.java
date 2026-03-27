// RSA algorithm string without OAEP flows to getAlgoSpec() should be flagged as Positive.
package scensct.var.pos;

import javax.crypto.Cipher;

public class PosCase1_Var1 {
    public static void main(String[] args) throws Exception {
        // Variant 1: String concatenation with compile-time constants
        String base = "RSA/ECB/";
        String padding = "PKCS1Padding";
        String algo = base + padding;
        Cipher cipher = Cipher.getInstance(algo);
    }
}