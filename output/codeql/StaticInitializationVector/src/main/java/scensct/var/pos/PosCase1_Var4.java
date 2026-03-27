// A method creates a byte array initialized with compile-time constants and passes it as IV to Cipher.init should be flagged as predictable IV.
package scensct.var.pos;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class PosCase1_Var4 {
    // Variant 4: Idiomatic variation - use a static final constant for the IV array
    private static final byte[] STATIC_IV = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};

    public void encrypt() throws Exception {
        Key key = new SecretKeySpec(new byte[16], "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(STATIC_IV)); // [REPORTED LINE]
    }
}