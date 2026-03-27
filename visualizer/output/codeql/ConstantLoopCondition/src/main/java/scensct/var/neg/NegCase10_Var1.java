// Loop with constant condition re-evaluation but condition contains array access should not be flagged.
package scensct.var.neg;

public class NegCase10_Var1 {
    public static void main(String[] args) {
        int[] data = {1, 2, 3};
        for (int idx = 0; data[idx] >= 1; ) {
            idx = idx + 1;
        }
    }
}