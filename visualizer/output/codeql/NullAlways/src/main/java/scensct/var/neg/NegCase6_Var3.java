// Dereference in block guarded by null check where variable is known non-null (unreachable) should not be flagged as always null.
package scensct.var.neg;

public class NegCase6_Var3 {
    // Variant 3: Inter-procedural - extract guard and dereference into a helper
    private static void unsafeDereference(Object param) {
        // This method would dereference if param were null, but it's never called with null
        System.out.println(param.toString());
    }

    public static void main(String[] args) {
        Object local = new Object();
        if (local == null) {
            unsafeDereference(local);
        }
    }
}