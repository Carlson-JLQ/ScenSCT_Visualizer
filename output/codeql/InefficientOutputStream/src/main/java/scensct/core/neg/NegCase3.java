// Concrete class that does not extend OutputStream or FilterOutputStream should not be flagged.
package scensct.core.neg;

public class NegCase3 {
    // This class does not extend OutputStream or FilterOutputStream.
    public void someMethod() {
        // No write methods.
    }
}