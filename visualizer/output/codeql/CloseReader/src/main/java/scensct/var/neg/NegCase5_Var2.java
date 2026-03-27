// A locally initialized FileInputStream that escapes via return should not be flagged as a leak.
package scensct.var.neg;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

public class NegCase5_Var2 {
    // Variant 2: Intra-procedural refactoring - introduce a temporary variable with conditional but always return it.
    public InputStream test() throws IOException {
        InputStream stream = null;
        // Simple condition that always evaluates to true, but adds control flow.
        if (System.currentTimeMillis() > 0) {
            stream = new FileInputStream("test.txt");
        } else {
            // Dead code, never executed.
            stream = new FileInputStream("dummy.txt");
        }
        return stream; // Resource escapes via return.
    }
}