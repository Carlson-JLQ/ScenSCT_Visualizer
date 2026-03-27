// A program with a static byte array source and sinks, but no encryption IV sinks, should not be flagged as using a static byte array as IV.
package scensct.core.neg;

import javax.crypto.Cipher;

public class NegCase5 {
    public static void main(String[] args) throws Exception {
        // Static byte array source.
        byte[] data = {0, 1, 2};
        // Sink is Cipher initialization, but not for IV (using ECB mode, no IV).
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, new javax.crypto.spec.SecretKeySpec(new byte[16], "AES"));
        byte[] encrypted = cipher.doFinal(data); // data is used as plaintext, not as IV.
    }
}