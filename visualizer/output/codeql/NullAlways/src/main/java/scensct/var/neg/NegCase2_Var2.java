// Dereference of a field variable should not be flagged as always null.
package scensct.var.neg;

public class NegCase2_Var2 {
    private Object field = null;
    
    public void method() {
        // Dereference inside a tautological if (always true)
        if (true) {
            System.out.println(field.toString());
        }
    }
}