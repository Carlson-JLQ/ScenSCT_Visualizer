// Concrete class extending OutputStream that declares write(int) and inherits a three-parameter write method, but that inherited three-parameter write is not declared in OutputStream or FilterOutputStream, should not be flagged.
package scensct.var.neg;

import java.io.IOException;
import java.io.OutputStream;

public class NegCase8_Var2 extends OutputStream {
    @Override
    public void write(int b) throws IOException {
        // empty
    }

    // Introduce an interface that defines three-param write, but class still extends OutputStream.
    interface ByteWriter {
        void write(byte[] arr, int off, int len) throws IOException;
    }

    public static class Intermediate extends OutputStream implements ByteWriter {
        // Explicitly implement interface method (overrides OutputStream's version).
        @Override
        public void write(byte[] b, int off, int len) throws IOException {
            // custom
        }

        @Override
        public void write(int b) throws IOException {
            // required
        }
    }

    public static class NegCase8_Var2Inner extends Intermediate {
        @Override
        public void write(int b) throws IOException {
            // do nothing
        }
        // Inherits write(byte[],int,int) from Intermediate.
    }
}