// A ByteArrayInputStream passed to a wrapper constructor and escaping should not be flagged as a leak.
package scensct.var.neg;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.IOException;

public class NegCase6_Var4 {
    static class Wrapper {
        private final InputStream inner;
        Wrapper(InputStream in) { this.inner = in; }
    }

    private Wrapper field;

    public void test() {
        // Variant 4: Use InputStream reference type, assign field after conditional.
        InputStream is = new ByteArrayInputStream("test".getBytes());
        if (field == null) {
            field = new Wrapper(is);
        } else {
            field = new Wrapper(is); // same branch, but flow analysis must see escape
        }
    }
}