// A program with a byte array where at least one element is not a compile-time constant should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase6_Var4 {
    // Variant 4: Extract array creation to a helper method.
    private static byte[] createArray() {
        return new byte[] {0, 1, (byte) Math.random()};
    }

    public static void main(String[] args) {
        byte[] iv = createArray();
        System.out.println(iv[2]);
    }
}