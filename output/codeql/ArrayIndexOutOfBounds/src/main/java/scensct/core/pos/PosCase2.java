// Array access with index bounded above by K >= array length should be flagged.
package scensct.core.pos;

public class PosCase2 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        int K = 5; // K equals array length
        int index = K; // Index bounded above by K, which is >= array length
        int value = arr[index]; // Potential out-of-bounds access // [REPORTED LINE]
    }
}