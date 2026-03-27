// A Writer flowing into a chain of two inner closeable resources should not be flagged.
package scensct.core.neg;

import java.io.Writer;
import java.io.Closeable;
import java.io.IOException;

public class NegCase5 {
    // First inner resource.
    static class InnerWriter1 extends Writer {
        private Writer inner;
        InnerWriter1(Writer w) { this.inner = w; }
        public void write(char[] cbuf, int off, int len) throws IOException { inner.write(cbuf, off, len); }
        public void flush() throws IOException { inner.flush(); }
        public void close() throws IOException { /* empty close */ }
        public void write(int c) throws IOException { inner.write(c); }
        public void write(String str) throws IOException { inner.write(str); }
        public void write(String str, int off, int len) throws IOException { inner.write(str, off, len); }
        public Writer append(CharSequence csq) throws IOException { return inner.append(csq); }
        public Writer append(CharSequence csq, int start, int end) throws IOException { return inner.append(csq, start, end); }
        public Writer append(char c) throws IOException { return inner.append(c); }
    }
    // Second inner resource.
    static class InnerWriter2 extends Writer {
        private Writer inner;
        InnerWriter2(Writer w) { this.inner = w; }
        public void write(char[] cbuf, int off, int len) throws IOException { inner.write(cbuf, off, len); }
        public void flush() throws IOException { inner.flush(); }
        public void close() throws IOException { /* empty close */ }
        public void write(int c) throws IOException { inner.write(c); }
        public void write(String str) throws IOException { inner.write(str); }
        public void write(String str, int off, int len) throws IOException { inner.write(str, off, len); }
        public Writer append(CharSequence csq) throws IOException { return inner.append(csq); }
        public Writer append(CharSequence csq, int start, int end) throws IOException { return inner.append(csq, start, end); }
        public Writer append(char c) throws IOException { return inner.append(c); }
    }
    
    public static void main(String[] args) throws Exception {
        // Scenario 5: Writer flows into InnerWriter1, which flows into InnerWriter2.
        Writer base = new java.io.StringWriter(); // In-memory to avoid external resource.
        InnerWriter1 inner1 = new InnerWriter1(base);
        InnerWriter2 inner2 = new InnerWriter2(inner1); // Chain of two inner resources.
        inner2.write("chain");
        // Both inner resources have empty close methods.
    }
}