// Second dereference of a non-field variable in same basic block should not be flagged as always null.
package scensct.var.neg;

public class NegCase8_Var3 {
    private static Object maybeCreate(boolean cond) {
        if (cond) {
            return new Object();
        }
        return null;
    }

    public static void main(String[] args) {
        Object local = null;
        local = maybeCreate(args.length > 0);
        System.out.println(local.hashCode());
    }
}