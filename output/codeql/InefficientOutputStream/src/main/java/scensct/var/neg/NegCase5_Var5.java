// Concrete class extending OutputStream that declares at least one method, but no method named write, should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase5_Var5 extends OutputStream {
    // Static method, still a declared method in the class
    public static void utility() {
        // Static helper
    }
    
    @Override
    public void write(int b) throws IOException {
        // Implementation
    }
}