// Dereference in block guarded by null check where variable is known non-null (unreachable) should not be flagged as always null.
package scensct.var.neg;

public class NegCase6_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical refactoring with inverted condition and early return
        Object obj = "non-null";
        if (obj != null) {
            // This block is reachable, but we keep the unreachable block separate
            // by using a nested always-false guard
            if (obj == null) {
                System.out.println(obj.toString());
            }
        }
    }
}