// A program with a static byte array source but no encryption IV sink should not be flagged as using a static byte array as IV.
package scensct.core.neg;

public class NegCase4 {
    public static void main(String[] args) {
        // Static byte array source exists.
        byte[] iv = {0, 1, 2, 3, 4, 5, 6, 7};
        // No encryption IV sink present.
        System.out.println(iv.length);
    }
}