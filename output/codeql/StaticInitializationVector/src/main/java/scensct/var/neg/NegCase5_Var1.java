// A program with a static byte array source and sinks, but no encryption IV sinks, should not be flagged as using a static byte array as IV.
package scensct.var.neg;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class NegCase5_Var1 {
    // Variant 1: Extract static array to a constant field, use in a method.
    private static final byte[] STATIC_DATA = {0, 1, 2};
    
    public static void main(String[] args) throws Exception {
        // Use the static field via a local variable.
        byte[] localData = STATIC_DATA.clone();
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKeySpec key = new SecretKeySpec(new byte[16], "AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        // Encrypt the static data (not IV).
        byte[] encrypted = cipher.doFinal(localData);
    }
}