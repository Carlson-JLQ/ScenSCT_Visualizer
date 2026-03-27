// A program with a static byte array source and an encryption IV sink, but no data flow path between them, should not be flagged as using a static byte array as IV.
package scensct.var.neg;

import javax.crypto.spec.IvParameterSpec;
import java.security.SecureRandom;

public class NegCase10_Var5 {
    // Encapsulate static array in an inner class.
    static class Holder {
        static byte[] DATA = {0, 1, 2, 3, 4, 5, 6, 7};
    }

    public static void main(String[] args) throws Exception {
        // IV generation via a lambda that captures nothing static.
        IvParameterSpec ivSpec = createIvSpec();
        // Access static array via Holder, but no flow.
        byte[] localRef = Holder.DATA;
        System.out.println(localRef.hashCode());
    }

    private static IvParameterSpec createIvSpec() {
        SecureRandom sr = new SecureRandom();
        byte[] iv = new byte[16];
        sr.nextBytes(iv);
        return new IvParameterSpec(iv);
    }
}