// Custom InputStream without close() method created but not closed should be flagged.
package scensct.ref.pos;

import java.io.InputStream;

public class PosCase2_FN1 {
    // Custom InputStream that does not declare close()
    static class CustomStream extends InputStream {
        @Override
        public int read() {
            return -1;
        }
        // No close() method overridden
    }

    public void useStream() {
        new CustomStream(); // Instantiation without assignment, close, or pass
    }
}