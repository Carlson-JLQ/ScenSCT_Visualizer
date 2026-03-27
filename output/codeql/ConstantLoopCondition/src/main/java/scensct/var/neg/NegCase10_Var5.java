// Loop with constant condition re-evaluation but condition contains array access should not be flagged.
package scensct.var.neg;

public class NegCase10_Var5 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int k = 0;
        boolean proceed = true;
        for (; proceed && arr[k] > 0; k++) {
            proceed = (k + 1) < arr.length;
        }
    }
}