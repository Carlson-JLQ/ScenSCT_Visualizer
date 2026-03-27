// Loop condition same at re-entry but successor not parent, and infinite loop with condition block not controlling all exits should not be flagged.
package scensct.var.neg;

public class NegCase6_Var1 {
    public static void main(String[] args) {
        // Infinite loop with constant condition.
        for (;;) {
            boolean exitFlag = someCondition();
            if (!exitFlag) {
                // No exit here.
            } else {
                break; // Exit not controlled by loop condition.
            }
            // No update to change condition.
        }
    }
    private static boolean someCondition() {
        return Math.random() > 0.5;
    }
}