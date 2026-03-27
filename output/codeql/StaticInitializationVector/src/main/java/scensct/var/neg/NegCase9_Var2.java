// A program where a static byte array is updated before reaching any IV sink should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase9_Var2 {
    public static void main(String[] args) {
        // Static array defined as a field-like local (still local).
        final byte[] iv = {0x00, 0x01, 0x02, 0x03};
        // Update inside a conditional that always executes.
        if (args.length >= 0) { // always true
            iv[0] = (byte) ((System.currentTimeMillis() / 1000L) % 256);
        }
        // Print result.
        System.out.println(iv[0]);
    }
}