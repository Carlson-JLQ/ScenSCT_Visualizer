// Concrete class extending OutputStream that declares at least one method, but no method named write, should not be flagged.
package scensct.core.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase5 extends OutputStream {
    // Declares a method not named write.
    public void customMethod() throws IOException {
        // Method body.
    }
    @Override
    public void write(int b) throws IOException {
        // Minimal implementation to satisfy abstract method.
    }
}