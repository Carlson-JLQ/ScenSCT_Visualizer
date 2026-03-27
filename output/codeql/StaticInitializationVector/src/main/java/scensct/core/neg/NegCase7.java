// A program where a static byte array creation is not the data flow source node should not be flagged as using a static byte array as IV.
package scensct.core.neg;

public class NegCase7 {
    public static void main(String[] args) {
        // Static byte array creation exists.
        byte[] arr = new byte[] {0, 1};
        // Source node is a different expression (e.g., a variable read).
        byte[] source = arr; // The source node is the variable 'arr', not the array creation expression.
        System.out.println(source.length);
    }
}