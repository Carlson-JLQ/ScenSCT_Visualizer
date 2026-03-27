// Loop condition same at re-entry but successor not parent, and infinite loop with condition block not controlling all exits should not be flagged.
package scensct.var.neg;

public class NegCase6_Var3 {
    public static void main(String[] args) {
        // Infinite loop with constant condition.
        while (true) {
            if (shouldExit()) {
                break; // Exit not controlled by loop condition.
            }
            // No update to change condition.
        }
    }
    private static boolean shouldExit() {
        return someCondition();
    }
    private static boolean someCondition() {
        return Math.random() > 0.5;
    }
}