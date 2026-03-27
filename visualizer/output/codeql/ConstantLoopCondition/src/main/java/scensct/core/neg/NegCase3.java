// Loop condition same at re-entry via expected expression but re-entry not from body should not be flagged.
package scensct.core.neg;

public class NegCase3 {
    public static void main(String[] args) {
        int i = 0;
        // Condition 'i < 10' is same at re-entry via condition expression, but re-entry originates from outside loop body (i.e., normal loop flow).
        while (i < 10) {
            i++; // Update inside body, but re-entry path is standard loop back edge.
        }
    }
}