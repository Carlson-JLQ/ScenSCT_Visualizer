// Second dereference of a non-field variable in same basic block should not be flagged as always null.
package scensct.var.neg;

public class NegCase8_Var1 {
    public static void main(String[] args) {
        Object local = null;
        // Loop runs zero or one time
        for (int i = 0; i < 1 && args.length > 0; i++) {
            local = new Object();
        }
        // Dereference after loop, local may still be null
        System.out.println(local.hashCode());
    }
}