// A locally initialized FileInputStream that escapes via return should not be flagged as a leak.
package scensct.var.neg;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

public class NegCase5_Var5 {
    // Variant 5: Idiomatic variation - use a wrapper method that returns the stream after some no-op.
    public InputStream test() throws IOException {
        return wrapStream(new FileInputStream("test.txt"));
    }

    private InputStream wrapStream(InputStream is) {
        // No operation, just returns the same stream.
        // This adds an extra method call but preserves escape.
        return is;
    }
}