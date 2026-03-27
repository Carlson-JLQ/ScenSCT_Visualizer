// A program with a static byte array source but no encryption IV sink should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase4_Var5 {
    // Variant 5: Control-flow restructuring with conditional initialization
    public static void main(String[] args) {
        byte[] iv;
        if (args.length == 0) {
            iv = new byte[] { 0, 1, 2, 3, 4, 5, 6, 7 };
        } else {
            iv = new byte[8]; // Still static but zero-filled
        }
        // Array not passed to any cipher, only used in a benign method
        printFirstElement(iv);
    }

    private static void printFirstElement(byte[] arr) {
        if (arr.length > 0) {
            System.out.println(arr[0]);
        }
    }
}