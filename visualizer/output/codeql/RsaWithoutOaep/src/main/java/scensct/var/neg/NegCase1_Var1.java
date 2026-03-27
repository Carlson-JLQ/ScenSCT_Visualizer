// RSA algorithm specification containing OAEP should not be flagged as non-OAEP RSA cipher
package scensct.var.neg;

import javax.crypto.Cipher;

public class NegCase1_Var1 {
    public static void main(String[] args) throws Exception {
        // Split OAEP string into compile-time constant parts
        final String PREFIX = "RSA/ECB/";
        final String SUFFIX = "OAEPWithSHA-1AndMGF1Padding";
        final String ALGORITHM = PREFIX + SUFFIX;
        
        Cipher cipher = Cipher.getInstance(ALGORITHM);
    }
}