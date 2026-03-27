// Dereference of a field variable should not be flagged as always null.
package scensct.var.neg;

public class NegCase2_Var1 {
    private Object data = null;
    
    public void method() {
        // Access via 'this' explicit qualifier
        System.out.println(this.data.toString());
    }
}