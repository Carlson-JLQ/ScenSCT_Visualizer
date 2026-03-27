// A program where a static byte array is updated before reaching any IV sink should not be flagged as using a static byte array as IV.
package scensct.core.neg;

public class NegCase9 {
    public static void main(String[] args) {
        // Static byte array source.
        byte[] iv = {0, 1, 2, 3};
        // Array is updated (element modified).
        iv[0] = (byte) (System.currentTimeMillis() % 256);
        // No IV sink present after update.
        System.out.println(iv[0]);
    }
}