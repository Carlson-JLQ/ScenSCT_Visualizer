// Dereference of a field variable should not be flagged as always null.
package scensct.var.neg;

public class NegCase2_Var3 {
    private Object field = null;
    
    public void method() {
        // Introduce a local alias
        Object alias = this.field;
        System.out.println(alias.toString());
    }
}