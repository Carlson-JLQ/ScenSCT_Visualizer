// A ByteArrayInputStream passed to a wrapper constructor and escaping should not be flagged as a leak.
package scensct.var.neg;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.IOException;

public class NegCase6_Var3 {
    static class Wrapper {
        private final InputStream inner;
        Wrapper(InputStream in) { this.inner = in; }
    }

    private Wrapper field;

    // Helper method that creates and returns the wrapper
    private Wrapper makeWrapper(byte[] bytes) {
        return new Wrapper(new ByteArrayInputStream(bytes));
    }

    public void test() {
        // Variant 3: Move wrapper creation to a helper method.
        field = makeWrapper(new byte[10]);
    }
}