// Nullness flow from V to a different sink, not the dereference of V, should not be flagged as potential null pointer dereference.
package scensct.var.neg;

public class NegCase3_Var2 {
    public static void main(String[] args) {
        String v = null;
        // Control-flow: use a while loop that never executes
        while (v == null) {
            // null check inside loop, not a dereference
            break;
        }
        v = "now non-null";
        // Introduce a temporary alias
        String alias = v;
        System.out.println(alias.length());
    }
}