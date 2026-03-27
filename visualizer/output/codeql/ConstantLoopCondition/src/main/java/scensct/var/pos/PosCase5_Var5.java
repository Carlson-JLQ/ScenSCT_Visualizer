// while true loop with if condition using variable defined outside controlling all exits should be flagged as infinite loop
package scensct.var.pos;

public class PosCase5_Var5 {
    // Helper method to compute constant condition
    private static boolean shouldExit(int c) {
        return c == 1;
    }

    public static void main(String[] args) {
        int counter = 0;
        while (true) {
            // Exit condition hidden in method call
            if (shouldExit(counter)) {
                return;
            }
            System.out.println("stuck");
        }
    }
}