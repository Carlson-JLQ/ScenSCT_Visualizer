// A program where a static byte array is updated before reaching any IV sink should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase9_Var4 {
    public static void main(String[] args) {
        // Array initialized with a loop.
        byte[] iv = new byte[4];
        for (int i = 0; i < iv.length; i++) {
            iv[i] = (byte) i;
        }
        // Update in a try block.
        try {
            iv[0] = (byte) (Math.random() * 256);
        } finally {
            // Ensure mutation is visible.
        }
        // Still no IV sink.
        System.out.println(iv[0]);
    }
}