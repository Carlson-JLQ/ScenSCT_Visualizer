// Concrete class extending OutputStream that declares write(int) and inherits the three-parameter write from OutputStream, and the write(int) method body contains at least one method call, but none of the called methods are named write, should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase10_Var3 extends OutputStream {
    private final Object lock = new Object();

    @Override
    public void write(int b) throws IOException {
        // Transform: introduce a temporary variable and a loop
        int tmp = b & 0xFF;
        for (int i = 0; i < 1; i++) {
            invokeHelper(tmp);
        }
    }

    private void invokeHelper(int x) {
        synchronized (lock) {
            // do nothing meaningful
        }
    }

    // Add a static initializer
    static {
        System.loadLibrary("dummy");
    }
}