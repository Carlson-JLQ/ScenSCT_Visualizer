// Loop condition not same at re-entry or loop is infinite with condition block not controlling all exits should not be flagged.
package scensct.var.neg;

public class NegCase5_Var3 {
    // Variant 3: extract loop body logic to a method, keep break in main loop
    private static boolean shouldBreak(int val) {
        return val == 5;
    }

    public static void main(String[] args) {
        int i = 0;
        while (i < 10) {
            if (shouldBreak(i)) {
                break;
            }
            i++;
        }
    }
}