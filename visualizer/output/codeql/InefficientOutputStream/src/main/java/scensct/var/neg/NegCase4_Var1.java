// Concrete class extending OutputStream that declares no methods should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase4_Var1 extends OutputStream {
    // Renamed class not needed; keep same public class name.
    // Slightly restructured method body with a local variable.
    @Override
    public void write(int b) throws IOException {
        int byteValue = b & 0xFF; // Isolate byte value
        // Do nothing, but with a local computation
        if (byteValue < 0) {
            // unreachable, just to add control flow
            throw new IOException("Impossible");
        }
    }
}