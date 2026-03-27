// A method creates a byte array initialized with compile-time constants and passes it as IV to Cipher.init should be flagged as predictable IV.
package scensct.var.pos;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class PosCase1_Var5 {
    public void encrypt() throws Exception {
        // Variant 5: Lexical and control flow refactoring - initialize array in a loop with constant values
        byte[] iv = new byte[16];
        for (int i = 0; i < iv.length; i++) {
            iv[i] = (byte) (i + 1); // Still compile-time constant pattern: values 1..16
        }
        Key key = new SecretKeySpec(new byte[16], "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv));
    }
}