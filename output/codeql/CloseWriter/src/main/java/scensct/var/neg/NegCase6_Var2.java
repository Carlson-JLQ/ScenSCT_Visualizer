// A Writer flowing to another closeable resource without special inner chain should not be flagged.
package scensct.var.neg;

import java.io.Writer;
import java.io.Closeable;
import java.io.IOException;

public class NegCase6_Var2 {
    static class OtherCloseableWriter extends Writer {
        private Writer delegate;
        OtherCloseableWriter(Writer w) { this.delegate = w; }
        public void write(char[] cbuf, int off, int len) throws IOException { delegate.write(cbuf, off, len); }
        public void flush() throws IOException { delegate.flush(); }
        public void close() throws IOException { delegate.close(); }
        public void write(int c) throws IOException { delegate.write(c); }
        public void write(String str) throws IOException { delegate.write(str); }
        public void write(String str, int off, int len) throws IOException { delegate.write(str, off, len); }
        public Writer append(CharSequence csq) throws IOException { return delegate.append(csq); }
        public Writer append(CharSequence csq, int start, int end) throws IOException { return delegate.append(csq, start, end); }
        public Writer append(char c) throws IOException { return delegate.append(c); }
    }
    
    // Variant 2: Extract creation and wrapping into a helper method.
    private static OtherCloseableWriter createWrappedWriter() {
        Writer base = new java.io.StringWriter();
        return new OtherCloseableWriter(base);
    }
    
    public static void main(String[] args) throws Exception {
        OtherCloseableWriter cie2 = createWrappedWriter();
        cie2.write("flow");
    }
}