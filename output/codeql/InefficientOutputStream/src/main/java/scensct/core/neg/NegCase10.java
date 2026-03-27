// Concrete class extending OutputStream that declares write(int) and inherits the three-parameter write from OutputStream, and the write(int) method body contains at least one method call, but none of the called methods are named write, should not be flagged.
package scensct.core.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase10 extends OutputStream {
    // Declares write(int) with method calls not named write.
    @Override
    public void write(int b) throws IOException {
        // Call a method not named write.
        someHelper();
    }
    private void someHelper() {
        // Helper method.
    }
}