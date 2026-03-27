// Non-dereference access of a non-field variable should not be flagged as always null.
package scensct.var.neg;

public class NegCase10_Var5 {
    // Variant 5: Use a ternary operator to conditionally assign, but local remains null
    public static void main(String[] args) {
        Object local = null;
        Object another = args.length == 0 ? local : local; // both branches are local (null)
        boolean isNull = (another == null) && (local == null); // compound comparison
    }
}