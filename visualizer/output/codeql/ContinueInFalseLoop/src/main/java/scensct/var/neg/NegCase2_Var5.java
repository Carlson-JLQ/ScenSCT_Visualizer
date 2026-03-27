// A do loop with literal true condition containing a continue should not be flagged as having a continue in a do loop with always false condition.
package scensct.var.neg;

public class NegCase2_Var5 {
    public static void main(String[] args) {
        // Variant 5: Inline the loop into a helper method, passing true as parameter
        runLoop(true);
    }
    
    private static void runLoop(boolean condition) {
        do {
            System.out.println("Loop body");
            continue;
        } while (condition);
    }
}