// Dereference in block guarded by null check where variable is known non-null (unreachable) should not be flagged as always null.
package scensct.var.neg;

public class NegCase6_Var4 {
    public static void main(String[] args) {
        // Variant 4: Control-flow restructuring with temporary variable and loop
        Object ref = new Object();
        boolean guard = (ref == null);
        for (int i = 0; i < 1; i++) {
            if (guard) {
                // Loop doesn't affect reachability of this block
                System.out.println(ref.toString());
                break;
            }
        }
    }
}