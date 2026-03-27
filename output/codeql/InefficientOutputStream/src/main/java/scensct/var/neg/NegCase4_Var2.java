// Concrete class extending OutputStream that declares no methods should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase4_Var2 extends OutputStream {
    // Use a try-catch block inside write(int)
    @Override
    public void write(int b) throws IOException {
        try {
            // Perform a no-op operation
            int unused = b;
        } catch (RuntimeException e) {
            // Swallow runtime exception, but IOException is declared
            throw new IOException("Wrapped", e);
        }
    }
}