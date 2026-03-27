// for loop with condition variable defined in initialization and no update effect should be flagged as infinite loop
package scensct.core.pos;

public class PosCase3 {
    public static void main(String[] args) {
        // Condition variable i defined in initialization, update i++ doesn't affect condition (i < 5)
        for (int i = 0; i < 5; i++) {
            // Loop body has path back to update, but condition remains constant (i never changes within iteration)
            // Actually i changes via update, but checker sees condition variable defined solely from initialization
            // Minimal case: condition uses variable from initialization, but update doesn't change condition value
            // Simpler: use variable from initialization that isn't updated
            int j = 0;
            for (int k = j; k < 3; k++) {
                // k defined from j (outside initialization), condition constant
                System.out.println("stuck");
            }
            break; // Prevent actual infinite loop in test
        }
    }
}