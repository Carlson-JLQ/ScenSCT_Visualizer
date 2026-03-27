// Concrete class extending OutputStream that declares write(int) and inherits the three-parameter write from OutputStream, and the write(int) method body contains at least one method call, but none of the called methods are named write, should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase10_Var1 extends OutputStream {
    private int state = 0;

    @Override
    public void write(int b) throws IOException {
        // Transform: use a conditional to guard the helper call
        if (b >= 0) {
            performAction();
        } else {
            performAction();
        }
    }

    private void performAction() {
        state++;
    }

    // Add an unrelated method to obscure the class structure
    public void reset() {
        state = 0;
    }
}