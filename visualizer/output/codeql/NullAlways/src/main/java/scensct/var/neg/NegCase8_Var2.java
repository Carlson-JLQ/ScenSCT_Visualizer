// Second dereference of a non-field variable in same basic block should not be flagged as always null.
package scensct.var.neg;

public class NegCase8_Var2 {
    public static void main(String[] args) {
        Object local = null;
        Object alias = local;
        if (args.length > 0) {
            alias = new Object();
            local = alias; // assignment through alias
        }
        System.out.println(local.hashCode());
    }
}