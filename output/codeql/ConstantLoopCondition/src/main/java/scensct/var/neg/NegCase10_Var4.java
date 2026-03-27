// Loop with constant condition re-evaluation but condition contains array access should not be flagged.
package scensct.var.neg;

public class NegCase10_Var4 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int j = 0;
        outer: {
            if (j >= arr.length) break outer;
            do {
                if (arr[j] <= 0) break outer;
                j++;
            } while (j < arr.length && arr[j] > 0);
        }
    }
}