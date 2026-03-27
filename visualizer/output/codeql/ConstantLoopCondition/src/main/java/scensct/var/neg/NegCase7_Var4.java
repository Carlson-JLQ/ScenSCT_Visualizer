// Loop with constant condition re-evaluation but variable defined inside loop should not be flagged.
package scensct.var.neg;

public class NegCase7_Var4 {
    public static void main(String[] args) {
        // Variant 4: Introduce a temporary variable and alias.
        while (true) {
            int x = 0;
            int y = x; // alias
            if (y == 0) {
                break;
            }
        }
    }
}