// A program with a byte array where at least one element is not a compile-time constant should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase6_Var5 {
    public static void main(String[] args) {
        // Variant 5: Use array initializer with a variable index assignment.
        byte[] iv = new byte[3];
        iv[0] = 0;
        iv[1] = 1;
        iv[2] = (byte) Math.random(); // Non-constant assignment.
        System.out.println(iv[2]);
    }
}