// A program with a static byte array source and sinks, but no encryption IV sinks, should not be flagged as using a static byte array as IV.
package scensct.var.neg;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class NegCase5_Var3 {
    // Variant 3: Inter-procedural refactoring: extract Cipher initialization.
    public static void main(String[] args) throws Exception {
        byte[] plaintext = getStaticData();
        Cipher cipher = prepareCipher();
        byte[] encrypted = cipher.doFinal(plaintext);
    }
    
    private static byte[] getStaticData() {
        return new byte[]{0, 1, 2};
    }
    
    private static Cipher prepareCipher() throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        SecretKeySpec key = new SecretKeySpec(new byte[16], "AES");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        return cipher;
    }
}