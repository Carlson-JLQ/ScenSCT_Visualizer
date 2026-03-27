// Loop with constant condition re-evaluation but variable defined inside loop should not be flagged.
package scensct.var.neg;

public class NegCase7_Var3 {
    // Variant 3: Extract condition check to a helper method.
    private static boolean shouldBreak(int val) {
        return val == 0;
    }
    
    public static void main(String[] args) {
        while (true) {
            int x = 0;
            if (shouldBreak(x)) {
                break;
            }
        }
    }
}