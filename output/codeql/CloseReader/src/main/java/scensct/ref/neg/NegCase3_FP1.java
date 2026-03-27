// A FileInputStream wrapped in a custom closeable with empty close should not be flagged as a leak.
package scensct.ref.neg;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

public class NegCase3_FP1 {
    // Custom wrapper with empty close method.
    static class NoCloseWrapper extends InputStream {
        private final InputStream inner;
        NoCloseWrapper(InputStream in) { this.inner = in; }
        @Override public int read() throws IOException { return inner.read(); }
        @Override public void close() { /* empty, no need to close inner */ }
    }

    public void test() throws IOException {
        // Scenario 3: Transitive closeable parent satisfies noNeedToClose.
        new NoCloseWrapper(new FileInputStream("test.txt")); // Inner resource managed by wrapper. // [REPORTED LINE]
    }
}