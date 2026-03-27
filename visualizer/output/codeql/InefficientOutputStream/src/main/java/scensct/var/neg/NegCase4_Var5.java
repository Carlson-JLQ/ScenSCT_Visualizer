// Concrete class extending OutputStream that declares no methods should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase4_Var5 extends OutputStream {
    // Use a loop inside write(int) to simulate some computation
    @Override
    public void write(int b) throws IOException {
        for (int i = 0; i < 1; i++) {
            // Loop runs once, does nothing
            if (b == i) {
                break;
            }
        }
    }
}