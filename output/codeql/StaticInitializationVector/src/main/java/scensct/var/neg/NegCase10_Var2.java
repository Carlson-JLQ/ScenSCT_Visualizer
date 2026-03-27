// A program with a static byte array source and an encryption IV sink, but no data flow path between them, should not be flagged as using a static byte array as IV.
package scensct.var.neg;

import javax.crypto.spec.IvParameterSpec;
import java.util.Arrays;

public class NegCase10_Var2 {
    public static void main(String[] args) throws Exception {
        // Static array initialized via Arrays.copyOf (still static content).
        byte[] staticSource = Arrays.copyOf(new byte[]{0, 1, 2, 3, 4, 5, 6, 7}, 8);
        // IV created via a dynamic method that uses system time.
        byte[] iv = createDynamicIv();
        IvParameterSpec ivSpec = new IvParameterSpec(iv);
        // Use staticSource in an unrelated way.
        for (byte b : staticSource) {
            System.out.print(b + " ");
        }
    }

    private static byte[] createDynamicIv() {
        byte[] dynamic = new byte[16];
        // Use current nano time to seed a simple pseudo-random fill (still dynamic).
        long seed = System.nanoTime();
        for (int i = 0; i < dynamic.length; i++) {
            dynamic[i] = (byte) ((seed >> (i * 4)) & 0xFF);
        }
        return dynamic;
    }
}