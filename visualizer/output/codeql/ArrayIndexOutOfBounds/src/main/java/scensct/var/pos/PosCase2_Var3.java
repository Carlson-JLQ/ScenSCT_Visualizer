// Array access with index bounded above by K >= array length should be flagged.
package scensct.var.pos;

public class PosCase2_Var3 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        int K = 5;
        // Use a loop to assign index (single iteration)
        int index = 0;
        for (int i = 0; i < 1; i++) {
            index = K;
        }
        int value = arr[index]; // [REPORTED LINE]
    }
}