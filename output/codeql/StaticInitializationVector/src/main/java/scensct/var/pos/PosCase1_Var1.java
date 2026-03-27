// A method creates a byte array initialized with compile-time constants and passes it as IV to Cipher.init should be flagged as predictable IV.
package scensct.var.pos;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class PosCase1_Var1 {
    public void encrypt() throws Exception {
        // Variant 1: Lexical refactoring - split array initialization and use a temporary variable
        byte[] iv = new byte[16];
        iv[0] = 1; iv[1] = 2; iv[2] = 3; iv[3] = 4;
        iv[4] = 5; iv[5] = 6; iv[6] = 7; iv[7] = 8;
        iv[8] = 9; iv[9] = 10; iv[10] = 11; iv[11] = 12;
        iv[12] = 13; iv[13] = 14; iv[14] = 15; iv[15] = 16;
        Key key = new SecretKeySpec(new byte[16], "AES");
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        cipher.init(Cipher.ENCRYPT_MODE, key, ivSpec); // [REPORTED LINE]
    }
}