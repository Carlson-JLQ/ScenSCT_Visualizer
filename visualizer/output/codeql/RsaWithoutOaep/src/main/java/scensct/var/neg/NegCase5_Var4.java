// RSA algorithm without OAEP and cryptographic sink present but no data flow path should not be flagged
package scensct.var.neg;

import javax.crypto.Cipher;

public class NegCase5_Var4 {
    public static void main(String[] args) throws Exception {
        final String ALG = "RSA/ECB/PKCS1Padding"; // [REPORTED LINE]
        int mode = 1;
        
        switch (mode) {
            case 1:
                // This runs
                break;
            default:
                // Never reached
                Cipher c = Cipher.getInstance(ALG); // [REPORTED LINE]
                break;
        }
        
        Cipher cipher2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
    }
}