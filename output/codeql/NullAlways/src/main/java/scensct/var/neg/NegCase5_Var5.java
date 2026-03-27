// Dereference of a non-field variable guarded by explicit non-null check should not be flagged as always null.
package scensct.var.neg;

public class NegCase5_Var5 {
    public static void main(String[] args) {
        Object local = null;
        boolean notNull = local != null;
        if (notNull) {
            System.out.println(local.toString());
        }
    }
}