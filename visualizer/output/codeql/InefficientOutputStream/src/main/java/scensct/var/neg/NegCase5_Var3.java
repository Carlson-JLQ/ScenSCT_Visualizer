// Concrete class extending OutputStream that declares at least one method, but no method named write, should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase5_Var3 extends OutputStream {
    // Private helper method, still counts as a declared method
    private void internalHelper() {
        // No-op
    }
    
    @Override
    public void write(int b) throws IOException {
        // Call helper (doesn't affect rule)
        internalHelper();
    }
}