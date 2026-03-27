// A program where a static byte array creation is not the data flow source node should not be flagged as using a static byte array as IV.
package scensct.var.neg;

public class NegCase7_Var5 {
    public static void main(String[] args) {
        // Variant 5: Try‑finally block that obscures but preserves data flow.
        byte[] arr = null;
        try {
            arr = new byte[] {0, 1};
        } finally {
            // no change to arr
        }
        byte[] source = arr;
        System.out.println(source.length);
    }
}