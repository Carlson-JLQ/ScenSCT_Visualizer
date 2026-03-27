// A program with array creation expressions that are not of byte type should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase3_Var2 {
    public static void main(String[] args) {
        // Variant 2: Introduce a temporary variable for the initializer
        int[] initializer = {1, 2, 3};
        int[] arr = initializer;
        System.out.println(arr.length);
    }
}