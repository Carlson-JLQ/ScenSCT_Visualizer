// RSA algorithm without OAEP and cryptographic sink present but no data flow path should not be flagged
package scensct.var.neg;

import javax.crypto.Cipher;

public class NegCase5_Var3 {
    public static void main(String[] args) throws Exception {
        final String RSA_ALG = "RSA/ECB/PKCS1Padding";
        
        try {
            // Normal path
            int x = 1 / 1; // no exception
        } catch (ArithmeticException e) {
            // Dead branch (never reached)
            Cipher c = Cipher.getInstance(RSA_ALG); // [REPORTED LINE]
            throw e;
        }
        
        Cipher cipher2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
    }
}