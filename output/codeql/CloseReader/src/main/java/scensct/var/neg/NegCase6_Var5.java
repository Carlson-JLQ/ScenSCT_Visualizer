// A ByteArrayInputStream passed to a wrapper constructor and escaping should not be flagged as a leak.
package scensct.var.neg;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.IOException;

public class NegCase6_Var5 {
    static class Wrapper {
        private final InputStream inner;
        Wrapper(InputStream in) { this.inner = in; }
    }

    private Wrapper field;

    public void test() {
        // Variant 5: Inline wrapper creation with a ternary operator.
        byte[] bytes = new byte[10];
        field = (System.currentTimeMillis() % 2 == 0)
            ? new Wrapper(new ByteArrayInputStream(bytes))
            : new Wrapper(new ByteArrayInputStream(bytes)); // both branches escape
    }
}