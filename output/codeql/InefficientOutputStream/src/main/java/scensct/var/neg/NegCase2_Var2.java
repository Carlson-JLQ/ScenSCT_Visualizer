// Concrete class that is exactly OutputStream or FilterOutputStream should not be flagged.
package scensct.var.neg;

import java.io.FilterOutputStream;
import java.io.OutputStream;

public class NegCase2_Var2 {
    // Variant 2: Intra-procedural refactoring - add a static factory method and a dummy finalizer, but still no overrides.
    public static final class NegCase2_Var2Inner extends FilterOutputStream {
        private NegCase2_Var2Inner(OutputStream out) {
            super(out);
        }
        public static NegCase2_Var2Inner create(OutputStream out) {
            return new NegCase2_Var2Inner(out);
        }
        @Override
        protected void finalize() throws Throwable {
            // Empty finalizer, does not affect write methods.
            super.finalize();
        }
    }
}