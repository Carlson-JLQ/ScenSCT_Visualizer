// Concrete class extending OutputStream that declares no methods should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase4_Var3 extends OutputStream {
    // Extract core logic to a private helper method
    @Override
    public void write(int b) throws IOException {
        handleByte(b);
    }

    private void handleByte(int b) throws IOException {
        // Empty implementation, but in separate method
        if (b == -1) {
            // Example of a no-op branch
            return;
        }
    }
}