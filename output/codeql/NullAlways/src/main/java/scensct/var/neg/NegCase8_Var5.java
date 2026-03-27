// Second dereference of a non-field variable in same basic block should not be flagged as always null.
package scensct.var.neg;

public class NegCase8_Var5 {
    public static void main(String[] args) {
        Object local = null;
        Object safe = new Object();
        // First dereference in block (safe)
        System.out.println(safe.hashCode());
        
        if (args.length > 0) {
            local = new Object();
        }
        // Second dereference in same block (conditional null)
        System.out.println(local.hashCode());
    }
}