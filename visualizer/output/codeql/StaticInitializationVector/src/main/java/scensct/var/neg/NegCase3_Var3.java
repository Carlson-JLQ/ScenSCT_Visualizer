// A program with array creation expressions that are not of byte type should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase3_Var3 {
    public static void main(String[] args) {
        // Variant 3: Control-flow restructuring with conditional initialization
        int[] arr;
        if (args.length == 0) {
            arr = new int[]{1, 2, 3};
        } else {
            arr = new int[]{};
        }
        System.out.println(arr.length);
    }
}