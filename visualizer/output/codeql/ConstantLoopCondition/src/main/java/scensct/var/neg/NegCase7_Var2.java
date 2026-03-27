// Loop with constant condition re-evaluation but variable defined inside loop should not be flagged.
package scensct.var.neg;

public class NegCase7_Var2 {
    public static void main(String[] args) {
        // Variant 2: Do-while loop with constant condition, but break inside based on inner variable.
        do {
            int x = 0;
            if (x == 0) {
                break;
            }
        } while (true);
    }
}