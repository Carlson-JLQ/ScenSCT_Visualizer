// A ByteArrayInputStream passed to a wrapper constructor and escaping should not be flagged as a leak.
package scensct.var.neg;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.IOException;

public class NegCase6_Var1 {
    static class Wrapper {
        private final InputStream inner;
        Wrapper(InputStream in) { this.inner = in; }
    }

    private Wrapper field;

    public void test() {
        // Variant 1: Split creation and assignment, use local variable for bytes.
        byte[] data = { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        ByteArrayInputStream bais = new ByteArrayInputStream(data);
        Wrapper w = new Wrapper(bais);
        field = w; // still escapes
    }
}