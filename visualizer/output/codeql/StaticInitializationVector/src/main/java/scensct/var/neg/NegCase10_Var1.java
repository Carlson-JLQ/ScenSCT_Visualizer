// A program with a static byte array source and an encryption IV sink, but no data flow path between them, should not be flagged as using a static byte array as IV.
package scensct.var.neg;

import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;

public class NegCase10_Var1 {
    // Move static array to a class field, but still no flow.
    private static final byte[] STATIC_DATA = {0x00, 0x01, 0x02, 0x03, 0x04, 0x05, 0x06, 0x07};

    public static void main(String[] args) throws Exception {
        // IV generation extracted to a helper method.
        byte[] ivBytes = generateRandomIv();
        IvParameterSpec ivSpec = new IvParameterSpec(ivBytes);
        // Static array is used only for a side calculation.
        int staticLength = computeLength(STATIC_DATA);
        System.out.println(staticLength);
    }

    private static byte[] generateRandomIv() {
        byte[] iv = new byte[16];
        new SecureRandom().nextBytes(iv);
        return iv;
    }

    private static int computeLength(byte[] arr) {
        return arr.length;
    }
}