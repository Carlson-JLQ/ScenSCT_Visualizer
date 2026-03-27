// Concrete class that is exactly OutputStream or FilterOutputStream should not be flagged.
package scensct.var.neg;

import java.io.FilterOutputStream;
import java.io.OutputStream;
import java.io.IOException;

public class NegCase2_Var5 {
    // Variant 5: Control-flow restructuring - add a trivial try-with-resources usage in a static method, but the class itself remains a simple FilterOutputStream.
    public static class SimpleFilterOut extends FilterOutputStream {
        public SimpleFilterOut(OutputStream out) {
            super(out);
        }
        // No overrides.
        public static void useStream(OutputStream out) throws IOException {
            try (SimpleFilterOut s = new SimpleFilterOut(out)) {
                s.write(42); // Calls inherited write(int)
            }
        }
    }
}