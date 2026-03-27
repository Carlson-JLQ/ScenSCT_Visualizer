// Loop condition same at re-entry but successor not parent, and infinite loop with condition block not controlling all exits should not be flagged.
package scensct.var.neg;

public class NegCase6_Var2 {
    public static void main(String[] args) {
        boolean flag;
        // Infinite loop with constant condition.
        do {
            {
                flag = someCondition();
                if (flag) {
                    break; // Exit not controlled by loop condition.
                }
            }
            // No update to change condition.
        } while (true);
    }
    private static boolean someCondition() {
        return Math.random() > 0.5;
    }
}