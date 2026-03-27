// Concrete class that is exactly OutputStream or FilterOutputStream should not be flagged.
package scensct.var.neg;

import java.io.FilterOutputStream;
import java.io.OutputStream;

public class NegCase2_Var3 {
    // Variant 3: Inter-procedural refactoring - move the concrete class to a separate static nested class with a helper interface.
    private interface StreamProvider {
        OutputStream getStream();
    }
    public static class InnerStream extends FilterOutputStream implements StreamProvider {
        public InnerStream(OutputStream out) {
            super(out);
        }
        @Override
        public OutputStream getStream() {
            return this;
        }
        // No write overrides.
    }
}