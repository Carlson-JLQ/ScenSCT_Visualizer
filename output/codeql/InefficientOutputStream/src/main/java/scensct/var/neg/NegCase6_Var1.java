// Concrete class extending OutputStream that declares a write method with exactly one parameter, but parameter type is not int, should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase6_Var1 extends OutputStream {
    // Keep write(byte) but move its logic to a private helper
    public void write(byte b) throws IOException {
        handleByte(b);
    }
    
    private void handleByte(byte b) {
        // Empty implementation, parameter type byte preserved
    }
    
    @Override
    public void write(int b) throws IOException {
        // Satisfy abstract method with a no-op
        if (b < 0) return; // dummy condition that never changes behavior
    }
}