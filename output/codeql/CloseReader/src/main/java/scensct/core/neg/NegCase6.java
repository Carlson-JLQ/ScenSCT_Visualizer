// A ByteArrayInputStream passed to a wrapper constructor and escaping should not be flagged as a leak.
package scensct.core.neg;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.IOException;

public class NegCase6 {
    static class Wrapper {
        private final InputStream inner;
        Wrapper(InputStream in) { this.inner = in; }
        // Assume Wrapper does not close inner and itself is not closed.
    }

    private Wrapper field;

    public void test() {
        // Scenario 6: Inner resource escapes (stored in field) via wrapper.
        field = new Wrapper(new ByteArrayInputStream(new byte[10])); // Inner escapes, no leak.
    }
}