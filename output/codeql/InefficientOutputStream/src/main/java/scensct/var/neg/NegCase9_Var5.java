// Concrete class extending OutputStream that declares write(int) and inherits the three-parameter write from OutputStream, but the write(int) method body contains no method calls, should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase9_Var5 extends OutputStream {
    private volatile int counter;

    // Variant 5: Synchronized block with primitive operations
    @Override
    public void write(int b) throws IOException {
        synchronized (this) {
            counter += b;
            if (counter < 0) {
                counter = Integer.MAX_VALUE;
            }
        }
        // No method calls remain
        int shadow = ~b;
    }
}