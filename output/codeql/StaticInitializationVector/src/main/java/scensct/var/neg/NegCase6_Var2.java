// A program with a byte array where at least one element is not a compile-time constant should not be flagged as using a static byte array as IV.
package scensct.var.neg;

import java.util.Random;

public class NegCase6_Var2 {
    public static void main(String[] args) {
        // Variant 2: Use Random class instead of Math.random, still non-constant.
        Random rand = new Random();
        byte[] iv = {0, 1, (byte) rand.nextInt()};
        System.out.println(iv[2]);
    }
}