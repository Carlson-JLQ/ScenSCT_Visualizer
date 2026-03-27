// Array access with index bounded above by K >= array length should be flagged.
package scensct.var.pos;

public class PosCase2_Var4 {
    public static void main(String[] args) {
        int[] arr = new int[5];
        int K = 5;
        // Introduce an alias reference
        int[] alias = arr;
        int index = K;
        int value = alias[index];
    }
}