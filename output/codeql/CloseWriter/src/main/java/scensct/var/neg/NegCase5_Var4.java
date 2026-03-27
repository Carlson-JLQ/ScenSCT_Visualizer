// A Writer flowing into a chain of two inner closeable resources should not be flagged.
package scensct.var.neg;

import java.io.Writer;
import java.io.Closeable;
import java.io.IOException;

public class NegCase5_Var4 {
    // InnerWriter1 with explicit delegation via method forwarding
    static class InnerWriter1 extends Writer {
        private Writer inner;
        InnerWriter1(Writer w) { this.inner = w; }
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
    
    // InnerWriter2 identical but with different internal variable name
    static class InnerWriter2 extends Writer {
        private Writer wrapped;
        InnerWriter2(Writer w) { this.wrapped = w; }
        public void write(char[] cbuf, int off, int len) throws IOException { wrapped.write(cbuf, off, len); }
        public void flush() throws IOException { wrapped.flush(); }
        public void close() throws IOException { /* empty */ }
        public void write(int c) throws IOException { wrapped.write(c); }
        public void write(String str) throws IOException { wrapped.write(str); }
        public void write(String str, int off, int len) throws IOException { wrapped.write(str, off, len); }
        public Writer append(CharSequence csq) throws IOException { return wrapped.append(csq); }
        public Writer append(CharSequence csq, int start, int end) throws IOException { return wrapped.append(csq, start, end); }
        public Writer append(char c) throws IOException { return wrapped.append(c); }
    }
    
    private static void useWriter(Writer w) throws IOException {
        w.write("chain");
    }
    
    public static void main(String[] args) throws Exception {
        Writer base = new java.io.StringWriter();
        InnerWriter1 i1 = new InnerWriter1(base);
        InnerWriter2 i2 = new InnerWriter2(i1);
        // Move write to a helper method
        useWriter(i2);
        // No close
    }
}