// Custom InputStream without close() method created but not closed should be flagged.
package scensct.core.pos;

import java.io.InputStream;
import java.io.IOException;

public class PosCase2 {
    // Custom InputStream that does not declare close()
    static class CustomStream extends InputStream {
        @Override
        public int read() {
            return -1;
        }
        // No close() method overridden
    }

    public void useStream() {
        InputStream stream = new CustomStream(); // Instantiation with assignment
        try {
            stream.read(); // Use the stream to emphasize it's a resource
        } catch (IOException e) {
            // Ignore for test purposes
        }
        // Not closed
    }
}