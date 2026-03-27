// Nullness flow from V to a different sink, not the dereference of V, should not be flagged as potential null pointer dereference.
package scensct.var.neg;

public class NegCase3_Var4 {
    public static void main(String[] args) {
        String v = null;
        // Use try-catch to embed null check (no exception thrown)
        try {
            if (v == null) {
                // do nothing
            }
        } finally {
            v = "now non-null";
        }
        System.out.println(v.length());
    }
}