// Concrete class extending OutputStream that declares a write method with exactly one parameter, but parameter type is not int, should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase6_Var2 extends OutputStream {
    // Write method with byte parameter, but wrapped in a try-catch for no reason
    public void write(byte b) throws IOException {
        try {
            // Do nothing
        } catch (RuntimeException e) {
            throw new IOException("Wrapped", e);
        }
    }
    
    @Override
    public void write(int b) throws IOException {
        // Minimal implementation with a local variable
        int local = b;
        // No operation
    }
}