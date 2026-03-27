// A ByteArrayInputStream passed to a wrapper constructor and escaping should not be flagged as a leak.
package scensct.var.neg;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.IOException;

public class NegCase6_Var2 {
    static class Wrapper {
        private final InputStream inner;
        Wrapper(InputStream in) { this.inner = in; }
    }

    private Wrapper field;

    public void test() {
        // Variant 2: Introduce a no-op try-catch around creation, field assigned in finally.
        ByteArrayInputStream stream = null;
        try {
            stream = new ByteArrayInputStream(new byte[10]);
        } catch (Exception e) {
            // ignore
        } finally {
            field = new Wrapper(stream); // stream escapes here
        }
    }
}