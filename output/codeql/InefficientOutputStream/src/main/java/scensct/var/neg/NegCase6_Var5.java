// Concrete class extending OutputStream that declares a write method with exactly one parameter, but parameter type is not int, should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase6_Var5 extends OutputStream {
    // Write method with byte parameter, but implementation uses a loop that never executes
    public void write(byte b) throws IOException {
        for (int i = 0; i < 0; i++) {
            throw new IOException("Never happens");
        }
    }
    
    @Override
    public void write(int b) throws IOException {
        // Use a switch with only default case
        switch (b) {
            default:
                break;
        }
    }
    
    // Add a constructor that does nothing
    public NegCase6_Var5() {
        super();
    }
}