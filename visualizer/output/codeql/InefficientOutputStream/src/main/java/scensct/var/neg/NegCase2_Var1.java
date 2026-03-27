// Concrete class that is exactly OutputStream or FilterOutputStream should not be flagged.
package scensct.var.neg;

import java.io.FilterOutputStream;
import java.io.OutputStream;

public class NegCase2_Var1 {
    // Variant 1: Lexical refactoring - rename inner class, add a private unused field, and a trivial no-args constructor overload.
    public static class CustomFilterStream extends FilterOutputStream {
        private final OutputStream delegate;
        public CustomFilterStream(OutputStream out) {
            super(out);
            this.delegate = out;
        }
        // No overrides of write methods.
    }
}