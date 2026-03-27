// Concrete class extending OutputStream that declares write(int) and inherits the three-parameter write from OutputStream, and the write(int) method body contains at least one method call, but none of the called methods are named write, should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase10_Var2 extends OutputStream {
    @Override
    public void write(int b) throws IOException {
        // Transform: wrap helper call in a try-catch block
        try {
            internalHelper(b);
        } catch (RuntimeException e) {
            // ignore
        }
    }

    private void internalHelper(int value) {
        System.err.println("Processing: " + value);
    }

    // Add a no-op three-parameter write that delegates to super (still inherits)
    // This is a red herring: it's a wrapper, not an override.
    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        super.write(b, off, len);
    }
}