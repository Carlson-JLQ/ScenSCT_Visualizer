// Final variable holding RSA algorithm without OAEP flows to getAlgoSpec() should be flagged as Positive.
package scensct.var.pos;

import javax.crypto.Cipher;

public class PosCase2_Var2 {
    // Variant 2: Inter-procedural refactoring - extract constant to static field
    private static final String ALGO_SPEC = "RSA/ECB/PKCS1Padding"; // [REPORTED LINE]
    
    public static void main(String[] args) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGO_SPEC); // [REPORTED LINE]
    }
}