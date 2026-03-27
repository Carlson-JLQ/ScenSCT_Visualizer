// Dereference of a non-field variable guarded by explicit non-null check should not be flagged as always null.
package scensct.var.neg;

public class NegCase5_Var1 {
    public static void main(String[] args) {
        Object local = null;
        if (local == null) {
            return; // early exit if null
        }
        // Now local is known non-null here (in the original logic, this path is unreachable)
        System.out.println(local.toString());
    }
}