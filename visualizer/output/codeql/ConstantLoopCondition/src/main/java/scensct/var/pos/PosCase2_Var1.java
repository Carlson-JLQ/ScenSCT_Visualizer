// while loop with condition using final field and variable defined outside should be flagged as infinite loop
package scensct.var.pos;

public class PosCase2_Var1 {
    private static final int LIMIT = 10;
    public static void main(String[] args) {
        int y = 3;
        // Use a temporary variable to hold the condition expression
        boolean shouldContinue = y < LIMIT;
        while (shouldContinue) { // [REPORTED LINE]
            System.out.println("stuck");
            // No update to y or shouldContinue
        }
    }
}