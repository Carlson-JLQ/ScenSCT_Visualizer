// Concrete class extending OutputStream that declares write(int) and inherits a three-parameter write method, but that inherited three-parameter write is not declared in OutputStream or FilterOutputStream, should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase8_Var5 extends OutputStream {
    @Override
    public void write(int b) throws IOException {
        // placeholder
    }

    // Intermediate with synchronized three-param write.
    public static class Intermediate extends OutputStream {
        @Override
        public synchronized void write(byte[] b, int off, int len) throws IOException {
            // synchronized override
        }

        @Override
        public void write(int b) throws IOException {
            // required
        }
    }

    // NegCase8_Var5Inner with a final write(int) method.
    public static class NegCase8_Var5Inner extends Intermediate {
        @Override
        public final void write(int b) throws IOException {
            // final override
        }
        // Inherits three-param write from Intermediate.
    }
}