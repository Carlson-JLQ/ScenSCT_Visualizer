// Concrete class extending OutputStream that declares write(int) and inherits a three-parameter write method, but that inherited three-parameter write is not declared in OutputStream or FilterOutputStream, should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase8_Var4 extends OutputStream {
    @Override
    public void write(int b) throws IOException {
        // original
    }

    // Intermediate that delegates three-param write to a helper method.
    public static class Intermediate extends OutputStream {
        private void helperWrite(byte[] bytes, int start, int count) throws IOException {
            // some logic
        }

        @Override
        public void write(byte[] b, int off, int len) throws IOException {
            helperWrite(b, off, len);
        }

        @Override
        public void write(int b) throws IOException {
            // required
        }
    }

    // NegCase8_Var4Inner that adds an overloaded write (single param) but still overrides write(int).
    public static class NegCase8_Var4Inner extends Intermediate {
        // Overload (not override) with byte[].
        public void write(byte[] data) throws IOException {
            // This is a different signature.
        }

        @Override
        public void write(int b) throws IOException {
            // override
        }
        // Inherits three-param write from Intermediate.
    }
}