// Nullness flow from V to a different sink, not the dereference of V, should not be flagged as potential null pointer dereference.
package scensct.var.neg;

public class NegCase3_Var3 {
    // Inter-procedural: extract null check to a helper
    private static boolean isNull(String s) {
        return s == null;
    }

    public static void main(String[] args) {
        String v = null;
        if (isNull(v)) {
            // null check via method call
        }
        v = "now non-null";
        System.out.println(v.length());
    }
}