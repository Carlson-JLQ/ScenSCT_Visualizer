// A Writer flowing into a chain of two inner closeable resources should not be flagged.
package scensct.var.neg;

import java.io.Writer;
import java.io.Closeable;
import java.io.IOException;

public class NegCase5_Var3 {
    // Single wrapper class reused for both layers
    static class EmptyCloseWriter extends Writer {
        private final Writer delegate;
        EmptyCloseWriter(Writer w) { delegate = w; }
        public void write(char[] cbuf, int off, int len) throws IOException { delegate.write(cbuf, off, len); }
        public void flush() throws IOException { delegate.flush(); }
        public void close() throws IOException { /* empty */ }
        public void write(int c) throws IOException { delegate.write(c); }
        public void write(String str) throws IOException { delegate.write(str); }
        public void write(String str, int off, int len) throws IOException { delegate.write(str, off, len); }
        public Writer append(CharSequence csq) throws IOException { return delegate.append(csq); }
        public Writer append(CharSequence csq, int start, int end) throws IOException { return delegate.append(csq, start, end); }
        public Writer append(char c) throws IOException { return delegate.append(c); }
    }
    
    public static void main(String[] args) throws Exception {
        // Create base and wrap twice in a different order: assign after wrapping
        java.io.StringWriter base;
        base = new java.io.StringWriter();
        EmptyCloseWriter layer1 = new EmptyCloseWriter(base);
        Writer finalWriter = new EmptyCloseWriter(layer1);
        // Write through a temporary variable
        Writer temp = finalWriter;
        temp.write("chain");
        // Introduce a try-with-resources that closes a dummy resource, but not our writers
        try (java.io.StringWriter dummy = new java.io.StringWriter()) {
            dummy.write("unrelated");
        }
        // Our writers never closed
    }
}