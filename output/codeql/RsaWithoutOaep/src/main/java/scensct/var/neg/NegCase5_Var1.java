// RSA algorithm without OAEP and cryptographic sink present but no data flow path should not be flagged
package scensct.var.neg;

import javax.crypto.Cipher;

public class NegCase5_Var1 {
    public static void main(String[] args) throws Exception {
        final String ALG = "RSA/ECB/PKCS1Padding"; // [REPORTED LINE]
        
        // Loop that never enters the block with the sink
        for (int i = 0; i < 10; i++) {
            if (i > 20) { // always false
                Cipher c = Cipher.getInstance(ALG); // no flow in reality // [REPORTED LINE]
                return;
            }
        }
        
        // Real sink with unrelated algorithm
        Cipher cipher2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
    }
}