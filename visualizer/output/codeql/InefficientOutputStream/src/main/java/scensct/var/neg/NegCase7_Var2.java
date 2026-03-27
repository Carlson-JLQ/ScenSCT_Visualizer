// Concrete class extending OutputStream that declares write(int) and inherits at least one method, but no inherited method is named write, should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase7_Var2 extends OutputStream {
    // Control-flow restructuring: wrap the override in a try-catch.
    @Override
    public void write(int b) throws IOException {
        try {
            // Do nothing, but demonstrate exception handling.
            if (b < 0) {
                throw new IOException("Negative byte mask");
            }
        } catch (RuntimeException e) {
            // Ignore runtime exceptions.
        }
    }
    
    // Add a static factory method.
    public static NegCase7_Var2 create() {
        return new NegCase7_Var2();
    }
}