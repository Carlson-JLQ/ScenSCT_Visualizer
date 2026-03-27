// Concrete class extending OutputStream that declares write(int) and inherits a three-parameter write method, but that inherited three-parameter write is not declared in OutputStream or FilterOutputStream, should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase8_Var3 extends OutputStream {
    @Override
    public void write(int b) throws IOException {
        // stub
    }

    // Intermediate with try-catch in three-param write.
    public static class Intermediate extends OutputStream {
        @Override
        public void write(byte[] b, int off, int len) throws IOException {
            try {
                if (len < 0) throw new IllegalArgumentException();
                // dummy loop
                for (int idx = off; idx < off + len; idx++) {
                    // no-op
                }
            } catch (RuntimeException e) {
                throw new IOException(e);
            }
        }

        @Override
        public void write(int b) throws IOException {
            // required
        }
    }

    // NegCase8_Var3Inner with a static factory method and private constructor.
    public static class NegCase8_Var3Inner extends Intermediate {
        private NegCase8_Var3Inner() {}

        public static NegCase8_Var3Inner create() {
            return new NegCase8_Var3Inner();
        }

        @Override
        public void write(int b) throws IOException {
            // override
        }
        // Inherits three-param write from Intermediate.
    }
}