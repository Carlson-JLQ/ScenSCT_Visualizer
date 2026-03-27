// Concrete class extending OutputStream that declares no methods should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase4_Var4 extends OutputStream {
    // Add a static final field and use it in write(int)
    private static final int MASK = 0xFF;

    @Override
    public void write(int b) throws IOException {
        // Mask and ignore
        int masked = b & MASK;
        // No operation
    }
}