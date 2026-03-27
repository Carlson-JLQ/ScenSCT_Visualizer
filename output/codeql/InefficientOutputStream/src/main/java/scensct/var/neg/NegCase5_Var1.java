// Concrete class extending OutputStream that declares at least one method, but no method named write, should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase5_Var1 extends OutputStream {
    // Renamed method, still not 'write'
    public void performAction() throws IOException {
        // Empty body
    }
    
    @Override
    public void write(int b) throws IOException {
        // Satisfy abstract method
    }
}