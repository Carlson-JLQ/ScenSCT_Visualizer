// A program with a static byte array source and sinks, but no encryption IV sinks, should not be flagged as using a static byte array as IV.
package scensct.var.neg;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Base64;

public class NegCase5_Var5 {
    // Variant 5: Idiomatic variation with try-with-resources and encoding.
    public static void main(String[] args) throws Exception {
        final byte[] staticBytes = {0, 1, 2};
        // Use a temporary variable to hold the data.
        byte[] input = new byte[staticBytes.length];
        System.arraycopy(staticBytes, 0, input, 0, staticBytes.length);
        
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKeySpec key = new SecretKeySpec(new byte[16], "AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        
        // Perform encryption (static bytes as plaintext).
        byte[] encrypted = cipher.doFinal(input);
        // Optional: encode result (irrelevant to rule).
        String encoded = Base64.getEncoder().encodeToString(encrypted);
    }
}