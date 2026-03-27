// RSA algorithm specification containing OAEP should not be flagged as non-OAEP RSA cipher
package scensct.var.neg;

import javax.crypto.Cipher;

public class NegCase1_Var4 {
    public static void main(String[] args) throws Exception {
        // Build OAEP string using StringBuilder
        StringBuilder sb = new StringBuilder();
        sb.append("RSA/ECB/");
        sb.append("OAEPWithSHA-1AndMGF1Padding");
        final String algorithm = sb.toString();
        
        Cipher cipher = Cipher.getInstance(algorithm);
    }
}