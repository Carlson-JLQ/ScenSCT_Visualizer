// A method creates a byte array initialized with compile-time constants and passes it as IV to Cipher.init should be flagged as predictable IV.
package scensct.var.pos;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class PosCase1_Var3 {
    public void encrypt() throws Exception {
        // Variant 3: Intra-procedural refactoring - wrap in a try-catch block and use a local variable for cipher
        byte[] iv = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        Key key = new SecretKeySpec(new byte[16], "AES");
        Cipher cipher = null;
        try {
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv)); // [REPORTED LINE]
        } catch (Exception e) {
            throw e;
        }
    }
}