// Concrete class that does not extend OutputStream or FilterOutputStream should not be flagged.
package scensct.var.neg;

// Variant 4: Refactor class to be final and add static factory method.
// Changes class modifiers and structure, but still not a stream subclass.
public final class NegCase3_Var4 {
    private NegCase3_Var4() {}
    
    public static NegCase3_Var4 create() {
        return new NegCase3_Var4();
    }
    
    public void someMethod() {
        // No write methods.
    }
}