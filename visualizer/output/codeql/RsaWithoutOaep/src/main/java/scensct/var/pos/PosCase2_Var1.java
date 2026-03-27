// Final variable holding RSA algorithm without OAEP flows to getAlgoSpec() should be flagged as Positive.
package scensct.var.pos;

import javax.crypto.Cipher;

public class PosCase2_Var1 {
    public static void main(String[] args) throws Exception {
        // Variant 1: Lexical refactoring - equivalent string concatenation
        final String RSA_ALGO = "RSA" + "/ECB/PKCS1Padding"; // [REPORTED LINE]
        Cipher cipher = Cipher.getInstance(RSA_ALGO); // [REPORTED LINE]
    }
}