// Loop with constant condition re-evaluation but variable defined inside loop should not be flagged.
package scensct.var.neg;

public class NegCase7_Var1 {
    public static void main(String[] args) {
        // Variant 1: Use for-loop with constant condition, variable defined inside.
        for (; true; ) {
            int local = 0;
            if (local == 0) {
                break;
            }
        }
    }
}