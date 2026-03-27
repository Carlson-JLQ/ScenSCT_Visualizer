// Dereference of a non-field variable guarded by explicit non-null check should not be flagged as always null.
package scensct.var.neg;

public class NegCase5_Var3 {
    public static void main(String[] args) {
        Object local = null;
        try {
            if (local != null) {
                System.out.println(local.toString());
            }
        } catch (RuntimeException e) {
            // ignore
        }
    }
}