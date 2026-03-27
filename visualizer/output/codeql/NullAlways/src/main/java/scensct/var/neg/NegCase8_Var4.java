// Second dereference of a non-field variable in same basic block should not be flagged as always null.
package scensct.var.neg;

public class NegCase8_Var4 {
    public static void main(String[] args) {
        Object local = null;
        try {
            if (args.length > 0) {
                local = new Object();
            }
        } catch (Exception e) {
            // ignore
        } finally {
            // no change to local
        }
        System.out.println(local.hashCode());
    }
}