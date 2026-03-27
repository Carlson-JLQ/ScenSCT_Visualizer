// A program where a zero-length byte array flows to a return statement should not be flagged as using a static byte array as IV.
package scensct.var.neg;

import java.util.Arrays;

public class NegCase8_Var2 {
    // Variant 2: Using Arrays.copyOf to produce zero-length array
    public static byte[] getEmptyArray() {
        byte[] emptySource = new byte[0];
        byte[] empty = Arrays.copyOf(emptySource, 0);
        return empty;
    }
    public static void main(String[] args) {
        byte[] arr = getEmptyArray();
        System.out.println(arr.length);
    }
}