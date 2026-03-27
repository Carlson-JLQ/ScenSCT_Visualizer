// Concrete class extending OutputStream that declares write(int) and inherits the three-parameter write from OutputStream, but the write(int) method body contains no method calls, should not be flagged.
package scensct.core.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase9 extends OutputStream {
    // Declares write(int) with no method calls in body.
    @Override
    public void write(int b) throws IOException {
        // No method calls, just a simple operation or empty.
        int x = b + 1;
    }
}