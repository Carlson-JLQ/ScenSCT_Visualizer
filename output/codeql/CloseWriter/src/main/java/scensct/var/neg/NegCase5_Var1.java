// A Writer flowing into a chain of two inner closeable resources should not be flagged.
package scensct.var.neg;

import java.io.Writer;
import java.io.Closeable;
import java.io.IOException;
import java.io.CharArrayWriter;

public class NegCase5_Var1 {
    // Combine both wrappers into a single generic delegating class
    static class DelegatingWriter extends Writer {
        private final Writer delegate;
        DelegatingWriter(Writer w) { this.delegate = w; }
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
    
    private static Writer makeFirstWrapper(Writer base) {
        return new DelegatingWriter(base);
    }
    
    private static Writer makeSecondWrapper(Writer first) {
        return new DelegatingWriter(first);
    }
    
    public static void main(String[] args) throws Exception {
        // Use CharArrayWriter instead of StringWriter, still in-memory
        Writer base = new CharArrayWriter();
        Writer wrapped1 = makeFirstWrapper(base);
        Writer wrapped2 = makeSecondWrapper(wrapped1);
        // Write via the final wrapper
        wrapped2.write("chain".toCharArray());
        // No close called
    }
}