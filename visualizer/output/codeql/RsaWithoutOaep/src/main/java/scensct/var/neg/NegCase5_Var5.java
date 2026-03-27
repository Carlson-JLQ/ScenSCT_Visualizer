// RSA algorithm without OAEP and cryptographic sink present but no data flow path should not be flagged
package scensct.var.neg;

import javax.crypto.Cipher;

public class NegCase5_Var5 {
    public static void main(String[] args) throws Exception {
        String rsaNonOaep = "RSA/ECB/PKCS1Padding"; // [REPORTED LINE]
        String alias = rsaNonOaep;
        
        boolean flag = Boolean.FALSE; // compile-time false
        if (flag) {
            Cipher cipher = Cipher.getInstance(alias);
        }
        
        Cipher cipher2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
    }
}