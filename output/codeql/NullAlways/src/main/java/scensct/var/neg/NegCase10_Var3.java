// Non-dereference access of a non-field variable should not be flagged as always null.
package scensct.var.neg;

public class NegCase10_Var3 {
    public static void main(String[] args) {
        // Variant 3: Control-flow restructuring with a branch that doesn't affect nullness
        Object local = null;
        if (args.length > 0) {
            // Still null, no assignment
        } else {
            // Also null
        }
        Object another = local; // assignment
        boolean isNull = (local == null) == true; // comparison with expression rewrite
    }
}