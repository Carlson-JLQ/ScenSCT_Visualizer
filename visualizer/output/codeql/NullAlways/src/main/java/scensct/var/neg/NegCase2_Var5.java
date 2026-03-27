// Dereference of a field variable should not be flagged as always null.
package scensct.var.neg;

public class NegCase2_Var5 {
    private Object field = null;
    
    public void method() {
        // Wrap in try-catch without affecting nullness
        try {
            System.out.println(field.toString());
        } catch (RuntimeException e) {
            throw e;
        }
    }
}