// A Writer flowing into a locally initialized closeable resource with empty close should not be flagged.
package scensct.var.neg;

import java.io.Writer;
import java.io.Closeable;
import java.io.IOException;

public class NegCase4_Var1 {
    static class NoOpWriter extends Writer {
        @Override public void write(char[] cbuf, int off, int len) { }
        @Override public void flush() { }
        @Override public void close() { } // Empty close
        @Override public void write(int c) { }
        @Override public void write(String str) { }
        @Override public void write(String str, int off, int len) { }
        @Override public Writer append(CharSequence csq) { return this; }
        @Override public Writer append(CharSequence csq, int start, int end) { return this; }
        @Override public Writer append(char c) { return this; }
    }
    
    public static void main(String[] args) throws Exception {
        // Variant 1: Lexical - rename class and variable, use different write overload
        NoOpWriter out = new NoOpWriter();
        out.append("test");
    }
}