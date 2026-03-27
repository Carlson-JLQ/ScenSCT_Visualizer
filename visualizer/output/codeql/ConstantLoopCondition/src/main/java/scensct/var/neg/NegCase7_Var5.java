// Loop with constant condition re-evaluation but variable defined inside loop should not be flagged.
package scensct.var.neg;

public class NegCase7_Var5 {
    public static void main(String[] args) {
        // Variant 5: Restructure with labeled break and nested block.
        outer: while (true) {
            {
                int x = 0;
                if (x == 0) {
                    break outer;
                }
            }
        }
    }
}