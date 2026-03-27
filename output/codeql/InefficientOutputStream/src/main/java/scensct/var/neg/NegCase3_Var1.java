// Concrete class that does not extend OutputStream or FilterOutputStream should not be flagged.
package scensct.var.neg;

// Variant 1: Add a method named 'write' but class does not extend stream.
// This tests if the checker incorrectly flags based on method name alone.
public class NegCase3_Var1 {
    public void someMethod() {
        // Original method kept.
    }
    
    // A write method that is not related to OutputStream.
    public void write(int b) {
        System.out.println("Not a stream write: " + b);
    }
}