// Nullness flow from a different variable to dereference should not be flagged as potential null pointer dereference for V.
package scensct.var.neg;

public class NegCase2_Var2 {
    public static void main(String[] args) {
        // Variant 2: Control-flow restructuring with early return
        String v = "non-null";
        String other = null;
        if (other == null) {
            // other being null does not affect v
            System.out.println(v.length());
            return;
        }
        // Unreachable dead code
        System.out.println("unreachable");
    }
}