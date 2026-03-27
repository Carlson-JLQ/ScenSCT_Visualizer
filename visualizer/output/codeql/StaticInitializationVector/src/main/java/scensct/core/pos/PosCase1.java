// A method creates a byte array initialized with compile-time constants and passes it as IV to Cipher.init should be flagged as predictable IV.
package scensct.core.pos;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class PosCase1 {
    public void encrypt() throws Exception {
        // Static byte array initialization with constants
        byte[] iv = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
        Key key = new SecretKeySpec(new byte[16], "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        // IV passed directly to Cipher.init
        cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv)); // [REPORTED LINE]
    }
}