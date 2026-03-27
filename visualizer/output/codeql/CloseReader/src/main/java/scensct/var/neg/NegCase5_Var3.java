// A locally initialized FileInputStream that escapes via return should not be flagged as a leak.
package scensct.var.neg;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

public class NegCase5_Var3 {
    // Variant 3: Inter-procedural refactoring - extract creation to a helper method.
    private FileInputStream createStream() throws IOException {
        return new FileInputStream("test.txt");
    }

    public InputStream test() throws IOException {
        // Resource created in helper and returned, still escapes.
        return createStream();
    }
}