// Loop with constant condition re-evaluation but condition contains array access should not be flagged.
package scensct.core.neg;

public class NegCase10 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};
        int i = 0;
        // Loop condition contains array access.
        while (arr[i] > 0) {
            // No update to change condition.
            i++;
        }
    }
}