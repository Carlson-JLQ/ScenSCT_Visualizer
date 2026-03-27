// A FileInputStream passed to a locally initialized outer constructor and escaping should not be flagged as a leak.
package scensct.ref.neg;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

public class NegCase7_FP1 {
    static class Outer {
        private final InputStream inner;
        Outer(InputStream in) { this.inner = in; } // No exceptions declared.
    }

    private Outer field;

    public void test() throws IOException {
        // Scenario 7: Resource not assigned, passed to constructor, escapes via field.
        field = new Outer(new FileInputStream("test.txt")); // Resource escapes, no leak. // [REPORTED LINE]
    }
}