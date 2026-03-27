// RSA algorithm without OAEP and cryptographic sink present but no data flow path should not be flagged
package scensct.var.neg;

import javax.crypto.Cipher;

public class NegCase5_Var2 {
    private static String getRSAAlg() {
        return "RSA/ECB/PKCS1Padding"; // [REPORTED LINE]
    }
    
    private static void deadPath() throws Exception {
        // This method is never called
        Cipher c = Cipher.getInstance(getRSAAlg());
    }
    
    public static void main(String[] args) throws Exception {
        String alg = getRSAAlg(); // source variable
        
        // Unrelated sink
        Cipher cipher2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
    }
}