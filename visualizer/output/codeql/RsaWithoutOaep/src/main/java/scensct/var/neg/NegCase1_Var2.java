// RSA algorithm specification containing OAEP should not be flagged as non-OAEP RSA cipher
package scensct.var.neg;

import javax.crypto.Cipher;

public class NegCase1_Var2 {
    private static String getAlgorithm() {
        return "RSA/ECB/OAEPWithSHA-1AndMGF1Padding";
    }
    
    public static void main(String[] args) throws Exception {
        String algorithmSpec = getAlgorithm();
        Cipher cipher = Cipher.getInstance(algorithmSpec);
    }
}