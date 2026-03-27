// Array access with index bounded below by negative K should be flagged.
package scensct.core.pos;

public class PosCase3 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        int K = -1; // Negative bound
        int index = K + 0; // Index bounded below by negative K
        int value = arr[index]; // Access with potentially negative index
    }
}