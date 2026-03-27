// Loop condition same at re-entry via expected expression but re-entry not from body should not be flagged.
package scensct.var.neg;

public class NegCase3_Var2 {
    public static void main(String[] args) {
        // Control-flow restructuring: for loop instead of while
        for (int i = 0; i < 10; i++) {
            // Body empty except implicit update in for header
        }
    }
}