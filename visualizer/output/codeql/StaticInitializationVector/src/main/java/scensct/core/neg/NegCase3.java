// A program with array creation expressions that are not of byte type should not be flagged as using a static byte array as IV.
package scensct.core.neg;

public class NegCase3 {
    public static void main(String[] args) {
        // Array creation is int[], not byte[].
        int[] arr = {1, 2, 3};
        System.out.println(arr.length);
    }
}