// Nullness flow from V to dereference exists but not due to guard, null argument, or direct null assignment should not be flagged.
package scensct.var.neg;

public class NegCase4_Var5 {
    static String getPossiblyNull(boolean flag) {
        return flag ? "non-null" : null;
    }
    
    public static void main(String[] args) {
        final String v;
        try {
            v = getPossiblyNull(true); // final assigned exactly once
        } catch (Exception e) {
            // never thrown, v stays unassigned in this path but unreachable
            throw new RuntimeException(e);
        }
        // v is definitely assigned and non-null
        System.out.println(v.length());
    }
}