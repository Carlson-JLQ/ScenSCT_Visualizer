// A program with a static byte array source and an encryption IV sink, but no data flow path between them, should not be flagged as using a static byte array as IV.
package scensct.core.neg;

import javax.crypto.spec.IvParameterSpec;

public class NegCase10 {
    public static void main(String[] args) throws Exception {
        // Static byte array source.
        byte[] staticArray = {0, 1, 2, 3, 4, 5, 6, 7};
        // IV sink uses a different, non-constant source.
        byte[] dynamicIv = new byte[16];
        new java.security.SecureRandom().nextBytes(dynamicIv);
        IvParameterSpec ivSpec = new IvParameterSpec(dynamicIv); // Sink uses dynamicIv, not staticArray.
        // No flow from staticArray to ivSpec.
        System.out.println(staticArray.length);
    }
}