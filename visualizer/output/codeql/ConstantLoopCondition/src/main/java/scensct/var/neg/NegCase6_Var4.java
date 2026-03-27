// Loop condition same at re-entry but successor not parent, and infinite loop with condition block not controlling all exits should not be flagged.
package scensct.var.neg;

public class NegCase6_Var4 {
    private static final boolean ALWAYS_TRUE = true;
    public static void main(String[] args) {
        // Infinite loop with constant condition.
        while (ALWAYS_TRUE) { // [REPORTED LINE]
            switch (someCondition() ? 1 : 0) {
                case 1:
                    break; // Exits the loop, not the switch.
                default:
                    // Continue.
            }
            // No update to change condition.
        }
    }
    private static boolean someCondition() {
        return Math.random() > 0.5;
    }
}