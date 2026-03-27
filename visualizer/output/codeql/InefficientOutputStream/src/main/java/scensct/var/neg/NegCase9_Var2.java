// Concrete class extending OutputStream that declares write(int) and inherits the three-parameter write from OutputStream, but the write(int) method body contains no method calls, should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase9_Var2 extends OutputStream {
    private int state;

    // Variant 2: Loop and arithmetic, no method calls
    @Override
    public void write(int b) throws IOException {
        for (int i = 0; i < 3; i++) {
            state += (b >> i) & 1;
        }
        if (state > 100) {
            state = 0;
        }
    }
}