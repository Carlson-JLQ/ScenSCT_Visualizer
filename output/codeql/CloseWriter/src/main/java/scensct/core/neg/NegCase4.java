// A Writer flowing into a locally initialized closeable resource with empty close should not be flagged.
package scensct.core.neg;

import java.io.Writer;
import java.io.Closeable;
import java.io.IOException;

public class NegCase4 {
    // Helper inner class with empty close method.
    static class EmptyCloseWriter extends Writer {
        public void write(char[] cbuf, int off, int len) throws IOException { }
        public void flush() throws IOException { }
        public void close() throws IOException { } // Empty close method, scenario 4.
        public void write(int c) throws IOException { }
        public void write(String str) throws IOException { }
        public void write(String str, int off, int len) throws IOException { }
        public Writer append(CharSequence csq) throws IOException { return this; }
        public Writer append(CharSequence csq, int start, int end) throws IOException { return this; }
        public Writer append(char c) throws IOException { return this; }
    }
    
    public static void main(String[] args) throws Exception {
        // Scenario 4: Writer flows into a locally initialized resource with empty close.
        Writer writer = new EmptyCloseWriter();
        writer.write("test");
        // No explicit close needed due to empty close method.
    }
}