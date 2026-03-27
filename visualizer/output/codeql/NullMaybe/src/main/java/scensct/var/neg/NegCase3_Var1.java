// Nullness flow from V to a different sink, not the dereference of V, should not be flagged as potential null pointer dereference.
package scensct.var.neg;

public class NegCase3_Var1 {
    public static void main(String[] args) {
        String v = null;
        // Lexical: invert condition, use else block (empty)
        if (v != null) {
            // unreachable
        } else {
            // null check here, still not a dereference
        }
        v = "now non-null";
        System.out.println(v.length());
    }
}