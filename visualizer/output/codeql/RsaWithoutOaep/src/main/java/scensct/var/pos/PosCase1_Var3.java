// RSA algorithm string without OAEP flows to getAlgoSpec() should be flagged as Positive.
package scensct.var.pos;

import javax.crypto.Cipher;

public class PosCase1_Var3 {
    // Variant 3: Inter-procedural - helper method returns the algorithm string
    private static String getAlgorithm() {
        return "RSA/ECB/PKCS1Padding"; // [REPORTED LINE]
    }

    public static void main(String[] args) throws Exception {
        String algo = getAlgorithm();
        Cipher cipher = Cipher.getInstance(algo);
    }
}