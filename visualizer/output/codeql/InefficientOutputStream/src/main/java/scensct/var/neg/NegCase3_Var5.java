// Concrete class that does not extend OutputStream or FilterOutputStream should not be flagged.
package scensct.var.neg;

// Variant 5: Use composition with an OutputStream field, but class itself does not extend.
// This mimics stream-like behavior via delegation, not inheritance.
public class NegCase3_Var5 {
    private java.io.OutputStream delegate;
    
    public NegCase3_Var5(java.io.OutputStream out) {
        this.delegate = out;
    }
    
    public void someMethod() {
        // No write methods.
    }
    
    public void writeByte(int b) throws java.io.IOException {
        delegate.write(b); // Delegation, not inheritance.
    }
}