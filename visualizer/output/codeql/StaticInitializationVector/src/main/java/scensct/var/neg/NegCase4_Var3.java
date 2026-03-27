// A program with a static byte array source but no encryption IV sink should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase4_Var3 {
    // Variant 3: Inter-procedural refactoring - static array returned from helper
    private static byte[] generateStaticArray() {
        return new byte[] { 0, 1, 2, 3, 4, 5, 6, 7 };
    }

    public static void main(String[] args) {
        byte[] iv = generateStaticArray();
        // Array exists but never used as IV
        for (byte b : iv) {
            System.out.print(b + " ");
        }
        System.out.println();
    }
}