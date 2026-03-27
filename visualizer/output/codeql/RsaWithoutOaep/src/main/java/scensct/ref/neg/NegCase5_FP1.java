// RSA algorithm without OAEP and cryptographic sink present but no data flow path should not be flagged
package scensct.ref.neg;

import javax.crypto.Cipher;

public class NegCase5_FP1 {
    public static void main(String[] args) throws Exception {
        // Source: compile-time constant RSA string without OAEP
        final String ALG = "RSA/ECB/PKCS1Padding";
        
        // Sink: cryptographic algorithm parameter in separate, unconnected path
        if (false) { // Dead code ensures no flow
            Cipher cipher = Cipher.getInstance(ALG); // [REPORTED LINE]
        }
        
        // Alternative sink with different, unrelated string
        Cipher cipher2 = Cipher.getInstance("AES/CBC/PKCS5Padding");
    }
}