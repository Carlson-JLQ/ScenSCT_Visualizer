// A program with a byte array where at least one element is not a compile-time constant should not be flagged as using a static byte array as IV.
package scensct.core.neg;

public class NegCase6 {
    public static void main(String[] args) {
        // Byte array with non-constant element (method call).
        byte[] iv = {0, 1, (byte) Math.random()};
        System.out.println(iv[2]);
    }
}