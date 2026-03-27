// Concrete class extending OutputStream that declares a write method with exactly one parameter, but parameter type is not int, should not be flagged.
package scensct.core.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase6 extends OutputStream {
    // Declares write with parameter type not int.
    public void write(byte b) throws IOException {
        // Parameter type is byte, not int.
    }
    @Override
    public void write(int b) throws IOException {
        // Minimal implementation to satisfy abstract method.
    }
}