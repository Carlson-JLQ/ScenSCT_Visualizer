// Nullness flow from V to dereference exists but not due to guard, null argument, or direct null assignment should not be flagged.
package scensct.var.neg;

public class NegCase4_Var2 {
    static String getPossiblyNull(boolean flag) {
        return flag ? "non-null" : null;
    }
    
    public static void main(String[] args) {
        String v = getPossiblyNull(true);
        // Add a no-op branch that the checker must ignore
        if (args.length > 1000) {
            v = null; // unreachable in practice
        } else {
            // keep flow
        }
        System.out.println(v.length()); // [REPORTED LINE]
    }
}