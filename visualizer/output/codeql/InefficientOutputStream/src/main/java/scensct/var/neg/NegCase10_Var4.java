// Concrete class extending OutputStream that declares write(int) and inherits the three-parameter write from OutputStream, and the write(int) method body contains at least one method call, but none of the called methods are named write, should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase10_Var4 extends OutputStream {
    // Transform: split the helper call across two private methods
    @Override
    public void write(int b) throws IOException {
        firstStep(b);
    }

    private void firstStep(int b) {
        secondStep();
    }

    private void secondStep() {
        // empty
    }

    // Add a factory method
    public static NegCase10_Var4 create() {
        return new NegCase10_Var4();
    }
}