// Loop condition same at re-entry but successor not parent, and infinite loop with condition block not controlling all exits should not be flagged.
package scensct.core.neg;

public class NegCase6 {
    public static void main(String[] args) {
        // Infinite loop with condition 'true'.
        while (true) {
            if (someCondition()) {
                break; // Exit not controlled by condition block matching loop condition (true).
            }
            // No update to change condition.
        }
    }
    private static boolean someCondition() {
        return Math.random() > 0.5;
    }
}