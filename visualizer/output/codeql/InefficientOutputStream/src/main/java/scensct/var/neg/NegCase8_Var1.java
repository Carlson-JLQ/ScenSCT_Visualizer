// Concrete class extending OutputStream that declares write(int) and inherits a three-parameter write method, but that inherited three-parameter write is not declared in OutputStream or FilterOutputStream, should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase8_Var1 extends OutputStream {
    @Override
    public void write(int b) throws IOException {
        // Unchanged.
    }

    // Rename Intermediate and add an extra dummy method.
    public static class MiddleLayer extends OutputStream {
        // Override three-param write with a more complex body.
        @Override
        public void write(byte[] data, int offset, int length) throws IOException {
            if (data == null) {
                throw new NullPointerException();
            }
            for (int i = 0; i < length; i++) {
                // dummy operation
            }
        }

        @Override
        public void write(int b) throws IOException {
            // Required.
        }
    }

    public static class NegCase8_Var1Inner extends MiddleLayer {
        // Override write(int) with a trivial implementation.
        @Override
        public void write(int b) throws IOException {
            // Single byte write.
        }
        // Inherits write(byte[],int,int) from MiddleLayer, not from OutputStream.
    }
}