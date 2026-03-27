// Loop with constant condition re-evaluation but condition contains array access should not be flagged.
package scensct.var.neg;

public class NegCase10_Var2 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int pos = 0;
        while (true) {
            int current = arr[pos];
            if (!(current > 0)) break;
            pos++;
        }
    }
}