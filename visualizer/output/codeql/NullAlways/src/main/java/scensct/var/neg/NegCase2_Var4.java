// Dereference of a field variable should not be flagged as always null.
package scensct.var.neg;

public class NegCase2_Var4 {
    private Object field = null;
    
    private Object getField() {
        return field;
    }
    
    public void method() {
        // Dereference via a getter method
        System.out.println(getField().toString());
    }
}