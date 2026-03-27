// Concrete class extending OutputStream that declares write(int) and inherits at least one method, but no inherited method is named write, should not be flagged.
package scensct.core.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase7 extends OutputStream {
    // Declares write(int).
    @Override
    public void write(int b) throws IOException {
        // Method body.
    }
    // This class does not inherit any write method because we override the only write method from OutputStream.
    // However, OutputStream has other methods like close(), flush(), etc., so it inherits at least one method.
    // The inherited methods are not named write.
}