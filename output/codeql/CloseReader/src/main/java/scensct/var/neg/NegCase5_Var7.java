// A locally initialized FileInputStream that escapes via return should not be flagged as a leak.
package scensct.var.neg;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

public class NegCase5_Var7 {
    // Variant 4 (clean): Introduce a dummy loop and break, but always return the stream.
    public InputStream test() throws IOException {
        InputStream result = null;
        for (int i = 0; i < 1; i++) {
            // Loop runs exactly once.
            result = new FileInputStream("test.txt");
            break; // Exit loop, but resource already created.
        }
        return result; // Resource escapes.
    }
}