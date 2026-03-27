// Concrete class extending OutputStream that declares at least one method, but no method named write, should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase5_Var4 extends OutputStream {
    // Method with try-catch, still not 'write'
    public void safeOperation() {
        try {
            // Attempt something
            int x = 1 / 1; // safe
        } catch (ArithmeticException e) {
            // ignore
        }
    }
    
    @Override
    public void write(int b) throws IOException {
        // Required override
    }
}