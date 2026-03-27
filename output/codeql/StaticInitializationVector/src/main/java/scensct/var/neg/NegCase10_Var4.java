// A program with a static byte array source and an encryption IV sink, but no data flow path between them, should not be flagged as using a static byte array as IV.
package scensct.var.neg;

import javax.crypto.spec.IvParameterSpec;
import java.util.Random;

public class NegCase10_Var4 {
    public static void main(String[] args) throws Exception {
        // Static array split into two parts.
        byte[] part1 = {0, 1, 2, 3};
        byte[] part2 = {4, 5, 6, 7};
        byte[] staticCombined = new byte[8];
        System.arraycopy(part1, 0, staticCombined, 0, 4);
        System.arraycopy(part2, 0, staticCombined, 4, 4);
        
        // IV generated using Random (less secure but still dynamic).
        Random rnd = new Random(System.currentTimeMillis());
        byte[] dynamicIv = new byte[16];
        rnd.nextBytes(dynamicIv);
        IvParameterSpec ivSpec = new IvParameterSpec(dynamicIv);
        
        // staticCombined used only for a checksum.
        int sum = 0;
        for (byte b : staticCombined) sum += b;
        System.out.println("Sum: " + sum);
    }
}