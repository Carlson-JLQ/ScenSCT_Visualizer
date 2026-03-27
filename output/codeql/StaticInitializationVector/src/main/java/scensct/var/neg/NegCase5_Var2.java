// A program with a static byte array source and sinks, but no encryption IV sinks, should not be flagged as using a static byte array as IV.
package scensct.var.neg;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;

public class NegCase5_Var2 {
    // Variant 2: Control flow restructuring with conditional assignment.
    public static void main(String[] args) throws Exception {
        byte[] data;
        if (args.length > 0) {
            data = args[0].getBytes();
        } else {
            data = new byte[]{0, 1, 2}; // Static source in else branch.
        }
        // Cipher in ECB mode, no IV.
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, 
                    new SecretKeySpec(Arrays.copyOf(data, 16), "AES")); // Key derived from data, not IV.
        // Use original static data as plaintext.
        byte[] encrypted = cipher.doFinal(data);
    }
}