// A Writer flowing to another closeable resource without special inner chain should not be flagged.
package scensct.var.neg;

import java.io.Writer;
import java.io.Closeable;
import java.io.IOException;

public class NegCase6_Var1 {
    static class OtherCloseableWriter extends Writer {
        private final Writer inner;
        OtherCloseableWriter(Writer w) { this.inner = w; }
        @Override public void write(char[] cbuf, int off, int len) throws IOException { inner.write(cbuf, off, len); }
        @Override public void flush() throws IOException { inner.flush(); }
        @Override public void close() throws IOException { inner.close(); }
        @Override public void write(int c) throws IOException { inner.write(c); }
        @Override public void write(String str) throws IOException { inner.write(str); }
        @Override public void write(String str, int off, int len) throws IOException { inner.write(str, off, len); }
        @Override public Writer append(CharSequence csq) throws IOException { return inner.append(csq); }
        @Override public Writer append(CharSequence csq, int start, int end) throws IOException { return inner.append(csq, start, end); }
        @Override public Writer append(char c) throws IOException { return inner.append(c); }
    }
    
    public static void main(String[] args) throws Exception {
        // Variant 1: Introduce a temporary variable and a no-op condition.
        Writer underlying = new java.io.StringWriter();
        if (args.length >= 0) { // always true
            OtherCloseableWriter wrapper = new OtherCloseableWriter(underlying);
            wrapper.append("flow");
        }
    }
}