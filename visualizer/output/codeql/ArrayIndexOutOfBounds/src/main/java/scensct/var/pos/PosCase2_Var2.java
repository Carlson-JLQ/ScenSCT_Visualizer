// Array access with index bounded above by K >= array length should be flagged.
package scensct.var.pos;

public class PosCase2_Var2 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        int K = 5;
        int index;
        // Restructure control flow with a trivial condition
        if (K >= 0) {
            index = K;
        } else {
            index = 0;
        }
        int value = arr[index]; // [REPORTED LINE]
    }
}