// Concrete class extending OutputStream that declares write(int) and inherits the three-parameter write from OutputStream, but the write(int) method body contains no method calls, should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase9_Var1 extends OutputStream {
    // Variant 1: Control flow without method calls
    @Override
    public void write(int b) throws IOException {
        if (b < 0) {
            throw new IOException("Negative byte value");
        }
        // Still no method call, just assignment
        int processed = b ^ 0xFF;
    }
}