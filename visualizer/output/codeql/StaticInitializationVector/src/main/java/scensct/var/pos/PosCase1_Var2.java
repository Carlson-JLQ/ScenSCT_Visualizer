// A method creates a byte array initialized with compile-time constants and passes it as IV to Cipher.init should be flagged as predictable IV.
package scensct.var.pos;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class PosCase1_Var2 {
    // Variant 2: Inter-procedural refactoring - extract IV creation to a helper method
    private byte[] createStaticIV() {
        return new byte[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16};
    }

    public void encrypt() throws Exception {
        byte[] iv = createStaticIV();
        Key key = new SecretKeySpec(new byte[16], "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key, new IvParameterSpec(iv)); // [REPORTED LINE]
    }
}