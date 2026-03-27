// A program where a static byte array creation is not the data flow source node should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase7_Var3 {
    public static void main(String[] args) {
        // Variant 3: Control‑flow with conditional assignment.
        byte[] arr = null;
        if (args.length == 0) {
            arr = new byte[] {0, 1};
        } else {
            arr = new byte[] {2, 3};
        }
        // Source is variable 'arr' after the branch.
        byte[] source = arr;
        System.out.println(source.length);
    }
}