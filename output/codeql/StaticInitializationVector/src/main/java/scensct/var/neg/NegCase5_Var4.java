// A program with a static byte array source and sinks, but no encryption IV sinks, should not be flagged as using a static byte array as IV.
package scensct.var.neg;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.SecureRandom;

public class NegCase5_Var4 {
    // Variant 4: Use a different Cipher mode that still doesn't require an IV (CFB with default segment size).
    public static void main(String[] args) throws Exception {
        byte[] data = {0, 1, 2};
        // CFB mode without explicit IV uses a default IV (not from our static array).
        Cipher cipher = Cipher.getInstance("AES/CFB/PKCS5Padding");
        // The IV is internally generated, not supplied by us.
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(new byte[16], "AES"));
        byte[] encrypted = cipher.doFinal(data); // data is plaintext, not IV.
    }
}