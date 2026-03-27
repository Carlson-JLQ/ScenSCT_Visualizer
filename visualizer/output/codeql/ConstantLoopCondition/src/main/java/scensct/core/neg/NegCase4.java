// Loop condition same at re-entry via expected expression from body but successor not parent should not be flagged.
package scensct.core.neg;

public class NegCase4 {
    public static void main(String[] args) {
        int i = 0;
        // Condition 'i < 10' is same at re-entry via condition, re-entry from body via continue.
        while (i < 10) {
            if (i % 2 == 0) {
                i++; // Update inside if, successor of last node (if) is not parent of re-entry expression.
                continue; // Re-entry originates from body.
            }
            i++;
        }
    }
}