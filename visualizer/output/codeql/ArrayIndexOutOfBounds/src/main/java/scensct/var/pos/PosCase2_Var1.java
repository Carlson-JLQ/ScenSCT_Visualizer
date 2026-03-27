// Array access with index bounded above by K >= array length should be flagged.
package scensct.var.pos;

public class PosCase2_Var1 {
    public static void main(String[] args) {
        int[] data = new int[5];
        final int bound = 5;
        int idx = bound;
        // Introduce a temporary variable that doesn't change the bound
        int temp = idx;
        int val = data[temp]; // [REPORTED LINE]
    }
}