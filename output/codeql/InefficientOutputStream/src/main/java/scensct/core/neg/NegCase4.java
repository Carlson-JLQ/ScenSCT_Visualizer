// Concrete class extending OutputStream that declares no methods should not be flagged.
package scensct.core.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase4 extends OutputStream {
    // No method declarations, only inherits from OutputStream.
    @Override
    public void write(int b) throws IOException {
        // Minimal implementation to satisfy abstract method.
    }
}