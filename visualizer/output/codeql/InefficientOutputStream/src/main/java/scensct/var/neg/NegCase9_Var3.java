// Concrete class extending OutputStream that declares write(int) and inherits the three-parameter write from OutputStream, but the write(int) method body contains no method calls, should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase9_Var3 extends OutputStream {
    // Variant 3: Try-catch-finally, still no method calls in write(int)
    @Override
    public void write(int b) throws IOException {
        try {
            int temp = b * 2;
            if (temp == b) {
                return;
            }
        } catch (Exception e) {
            // No method call here either
            int errorCode = -1;
        } finally {
            int cleanupFlag = 0;
        }
    }
}