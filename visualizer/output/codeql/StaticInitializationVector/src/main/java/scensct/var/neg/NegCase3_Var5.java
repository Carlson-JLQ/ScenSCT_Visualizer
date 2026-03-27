// A program with array creation expressions that are not of byte type should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase3_Var5 {
    public static void main(String[] args) {
        // Variant 5: Use a different non-byte primitive type (long) but same pattern
        long[] arr = {1L, 2L, 3L};
        System.out.println(arr.length);
    }
}