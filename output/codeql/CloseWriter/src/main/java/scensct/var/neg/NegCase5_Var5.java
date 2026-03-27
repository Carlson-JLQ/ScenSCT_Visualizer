// A Writer flowing into a chain of two inner closeable resources should not be flagged.
package scensct.var.neg;

import java.io.Writer;
import java.io.Closeable;
import java.io.IOException;

public class NegCase5_Var5 {
    // First inner resource as static nested class with factory
    static class InnerWriter1 extends Writer {
        private Writer inner;
        static InnerWriter1 wrap(Writer w) { return new InnerWriter1(w); }
        private InnerWriter1(Writer w) { this.inner = w; }
        public void write(char[] cbuf, int off, int len) throws IOException { inner.write(cbuf, off, len); }
        public void flush() throws IOException { inner.flush(); }
        public void close() throws IOException { /* empty */ }
        public void write(int c) throws IOException { inner.write(c); }
        public void write(String str) throws IOException { inner.write(str); }
        public void write(String str, int off, int len) throws IOException { inner.write(str, off, len); }
        public Writer append(CharSequence csq) throws IOException { return inner.append(csq); }
        public Writer append(CharSequence csq, int start, int end) throws IOException { return inner.append(csq, start, end); }
        public Writer append(char c) throws IOException { return inner.append(c); }
    }
    // Second inner resource as local class inside method
    public static void main(String[] args) throws Exception {
        class InnerWriter2 extends Writer {
            private Writer inner;
            InnerWriter2(Writer w) { this.inner = w; }
            public void write(char[] cbuf, int off, int len) throws IOException { inner.write(cbuf, off, len); }
            public void flush() throws IOException { inner.flush(); }
            public void close() throws IOException { /* empty */ }
            public void write(int c) throws IOException { inner.write(c); }
            public void write(String str) throws IOException { inner.write(str); }
            public void write(String str, int off, int len) throws IOException { inner.write(str, off, len); }
            public Writer append(CharSequence csq) throws IOException { return inner.append(csq); }
            public Writer append(CharSequence csq, int start, int end) throws IOException { return inner.append(csq, start, end); }
            public Writer append(char c) throws IOException { return inner.append(c); }
        }
        
        Writer base = new java.io.StringWriter();
        // Use factory for first, direct for second
        Writer inner1 = InnerWriter1.wrap(base);
        Writer inner2 = new InnerWriter2(inner1);
        // Write using append with null check (always true)
        if (inner2 != null) {
            inner2.append("chain");
        }
        // No close
    }
}