// Concrete class that does not extend OutputStream or FilterOutputStream should not be flagged.
package scensct.var.neg;

// Variant 3: Introduce an inner class that extends OutputStream, but outer class does not.
// The checker must not flag the outer class.
public class NegCase3_Var3 {
    public void someMethod() {
        // No write methods.
    }
    
    // Inner class that would be flagged if it were the target, but it's not the top-level class.
    public static class InnerStream extends java.io.OutputStream {
        @Override
        public void write(int b) {
            // Overrides only the single-byte write.
        }
    }
}