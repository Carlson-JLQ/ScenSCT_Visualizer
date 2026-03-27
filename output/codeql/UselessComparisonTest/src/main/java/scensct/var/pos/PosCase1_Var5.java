// Binary comparison inside loop with constant operands and increment compared to itself should be flagged as always true.
package scensct.var.pos;

public class PosCase1_Var5 {
    public static void main(String[] args) {
        // Variant 5: Nested loops, alias via array, and explicit constant addition
        int[] arr = new int[1];
        arr[0] = 0;
        for (int k = 0; k < 10; k++) {
            arr[0]++;
            boolean b = arr[0] > (arr[0] - 1); // Always true
            System.out.println(b);
        }
    }
}