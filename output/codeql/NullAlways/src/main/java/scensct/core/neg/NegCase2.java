// Dereference of a field variable should not be flagged as always null.
package scensct.core.neg;

public class NegCase2 {
    private Object field = null;
    
    public void method() {
        // Field dereference, not a local/parameter
        System.out.println(field.toString());
    }
}