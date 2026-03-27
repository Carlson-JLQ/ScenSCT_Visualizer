// Concrete class extending OutputStream that declares a write method with exactly one parameter, but parameter type is not int, should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase6_Var4 extends OutputStream {
    // Reorder methods: write(int) first
    @Override
    public void write(int b) throws IOException {
        // No-op
    }
    
    // The key write(byte) method
    public void write(byte data) throws IOException {
        // Parameter renamed, type unchanged
    }
    
    // Add a harmless public method that does not affect the rule
    public void flush() throws IOException {
        super.flush();
    }
}