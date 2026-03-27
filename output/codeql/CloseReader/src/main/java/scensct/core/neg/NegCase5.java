// A locally initialized FileInputStream that escapes via return should not be flagged as a leak.
package scensct.core.neg;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

public class NegCase5 {
    public InputStream test() throws IOException {
        // Scenario 5: Resource escapes method (returned).
        InputStream is = new FileInputStream("test.txt");
        return is; // No leak reported because resource escapes.
    }
}