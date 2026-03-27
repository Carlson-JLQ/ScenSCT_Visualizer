// Concrete class that is exactly OutputStream or FilterOutputStream should not be flagged.
package scensct.core.neg;

import java.io.FilterOutputStream;
import java.io.OutputStream;

public class NegCase2 {
    // The scenario requires a concrete class that is exactly OutputStream or FilterOutputStream.
    // Since we cannot modify java.io classes, we create a class that is exactly FilterOutputStream.
    // This is a concrete subclass of FilterOutputStream with no method overrides.
    public static class NegCase2Inner extends FilterOutputStream {
        public NegCase2Inner(OutputStream out) {
            super(out);
        }
    }
}