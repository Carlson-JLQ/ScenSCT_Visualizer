// Non-dereference access of a non-field variable should not be flagged as always null.
package scensct.var.neg;

public class NegCase10_Var2 {
    // Variant 2: Extract non-dereference accesses into a helper method
    private static void process(Object param) {
        Object alias = param; // assignment
        boolean test = param == null; // comparison
    }

    public static void main(String[] args) {
        Object local = null;
        process(local); // pass null, but no dereference inside
    }
}