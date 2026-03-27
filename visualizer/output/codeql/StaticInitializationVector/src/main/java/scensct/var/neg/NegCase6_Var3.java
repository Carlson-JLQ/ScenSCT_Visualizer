// A program with a byte array where at least one element is not a compile-time constant should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase6_Var3 {
    public static void main(String[] args) {
        // Variant 3: Restructure with an if-else that doesn't affect the non-constant element.
        boolean flag = true;
        byte[] iv;
        if (flag) {
            iv = new byte[] {0, 1, (byte) Math.random()};
        } else {
            iv = new byte[] {2, 3, 4}; // Unreachable, but preserves type.
        }
        System.out.println(iv[2]);
    }
}