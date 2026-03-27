// A Writer flowing into a chain of two inner closeable resources should not be flagged.
package scensct.var.neg;

import java.io.Writer;
import java.io.Closeable;
import java.io.IOException;

public class NegCase5_Var2 {
    // InnerWriter1 as anonymous class
    static Writer createInner1(Writer w) {
        return new Writer() {
            private Writer inner = w;
            public void write(char[] cbuf, int off, int len) throws IOException { inner.write(cbuf, off, len); }
            public void flush() throws IOException { inner.flush(); }
            public void close() throws IOException { /* empty */ }
            public void write(int c) throws IOException { inner.write(c); }
            public void write(String str) throws IOException { inner.write(str); }
            public void write(String str, int off, int len) throws IOException { inner.write(str, off, len); }
            public Writer append(CharSequence csq) throws IOException { return inner.append(csq); }
            public Writer append(CharSequence csq, int start, int end) throws IOException { return inner.append(csq, start, end); }
            public Writer append(char c) throws IOException { return inner.append(c); }
        };
    }
    
    // InnerWriter2 as lambda-like via abstract class (Writer is abstract, cannot lambda)
    static class InnerWriter2 extends Writer {
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
    
    public static void main(String[] args) throws Exception {
        Writer base = new java.io.StringWriter();
        // Chain creation in a single expression
        Writer inner2 = new InnerWriter2(createInner1(base));
        // Use a constant condition to obscure flow
        final boolean alwaysTrue = 1 > 0;
        if (alwaysTrue) {
            inner2.append("chain");
        } else {
            inner2.close(); // dead code, never executed
        }
    }
}