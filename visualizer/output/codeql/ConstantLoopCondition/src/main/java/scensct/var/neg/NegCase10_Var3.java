// Loop with constant condition re-evaluation but condition contains array access should not be flagged.
package scensct.var.neg;

public class NegCase10_Var3 {
    static boolean check(int[] a, int index) {
        return a[index] > 0;
    }

    public static void main(String[] args) {
        int[] values = {1, 2, 3};
        int i = 0;
        while (check(values, i)) {
            i = i + 1;
        }
    }
}