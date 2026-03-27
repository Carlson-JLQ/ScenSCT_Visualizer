// Array access with index bounded above by K >= array length should be flagged.
package scensct.var.pos;

public class PosCase2_Var5 {
    private static int getIndex(int k) {
        return k;
    }

    public static void main(String[] args) {
        int[] arr = new int[5];
        int K = 5;
        // Move index computation to a helper method
        int index = getIndex(K);
        int value = arr[index];
    }
}