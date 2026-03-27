// Loop condition same at re-entry but successor not parent, and infinite loop with condition block not controlling all exits should not be flagged.
package scensct.var.neg;

public class NegCase6_Var5 {
    public static void main(String[] args) {
        // Infinite loop with constant condition.
        while (true) {
            try {
                if (someCondition()) {
                    break; // Exit not controlled by loop condition.
                }
            } catch (Exception e) {
                // Never thrown.
            }
            // No update to change condition.
        }
    }
    private static boolean someCondition() {
        return Math.random() > 0.5;
    }
}