// Dereference of a non-field variable whose ultimate definition is not always null should not be flagged as always null.
package scensct.var.neg;

public class NegCase4_Var2 {
    public static void main(String[] args) {
        // Variant 2: Intra-procedural - Use try-finally block, but keep initialization non-null
        Object local = null;
        try {
            local = new Object();
        } finally {
            // local is non-null here if no exception occurred before assignment
            if (local != null) {
                System.out.println(local.toString());
            }
        }
    }
}