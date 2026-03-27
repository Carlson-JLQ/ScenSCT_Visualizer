// A Writer flowing to another closeable resource without special inner chain should not be flagged.
package scensct.var.neg;

import java.io.Writer;
import java.io.Closeable;
import java.io.IOException;

public class NegCase6_Var3 {
    static class OtherCloseableWriter extends Writer {
        private Writer sink;
        OtherCloseableWriter(Writer w) { this.sink = w; }
        public void write(char[] cbuf, int off, int len) throws IOException { sink.write(cbuf, off, len); }
        public void flush() throws IOException { sink.flush(); }
        public void close() throws IOException { sink.close(); }
        public void write(int c) throws IOException { sink.write(c); }
        public void write(String str) throws IOException { sink.write(str); }
        public void write(String str, int off, int len) throws IOException { sink.write(str, off, len); }
        public Writer append(CharSequence csq) throws IOException { return sink.append(csq); }
        public Writer append(CharSequence csq, int start, int end) throws IOException { return sink.append(csq, start, end); }
        public Writer append(char c) throws IOException { return sink.append(c); }
    }
    
    // Variant 3: Use try-with-resources on a dummy unrelated resource to add control flow.
    public static void main(String[] args) throws Exception {
        try (java.io.StringReader dummy = new java.io.StringReader("")) {
            Writer base = new java.io.StringWriter();
            OtherCloseableWriter cie2 = new OtherCloseableWriter(base);
            cie2.write("flow");
        }
    }
}