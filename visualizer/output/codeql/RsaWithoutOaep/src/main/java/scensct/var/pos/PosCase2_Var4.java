// Final variable holding RSA algorithm without OAEP flows to getAlgoSpec() should be flagged as Positive.
package scensct.var.pos;

import javax.crypto.Cipher;

public class PosCase2_Var4 {
    // Variant 4: Helper method extraction with constant return
    private static String getRsaAlgo() {
        return "RSA/ECB/PKCS1Padding"; // [REPORTED LINE]
    }
    
    public static void main(String[] args) throws Exception {
        Cipher cipher = Cipher.getInstance(getRsaAlgo());
    }
}