// Creating a ByteArrayInputStream (safe in-memory stream) should not be flagged as a resource leak.
package scensct.core.neg;

import java.io.ByteArrayInputStream;

public class NegCase2 {
    public void test() {
        // Scenario 2: Safe in-memory stream type.
        new ByteArrayInputStream(new byte[10]); // No need to close.
    }
}