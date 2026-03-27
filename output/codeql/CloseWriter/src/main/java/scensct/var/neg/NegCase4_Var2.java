// A Writer flowing into a locally initialized closeable resource with empty close should not be flagged.
package scensct.var.neg;

import java.io.Writer;
import java.io.Closeable;
import java.io.IOException;

public class NegCase4_Var2 {
    static class DummyWriter extends Writer {
        @Override public void write(char[] cbuf, int off, int len) throws IOException { }
        @Override public void flush() throws IOException { }
        @Override public void close() throws IOException { } // Empty
        @Override public void write(int c) throws IOException { }
        @Override public void write(String str) throws IOException { }
        @Override public void write(String str, int off, int len) throws IOException { }
        @Override public Writer append(CharSequence csq) throws IOException { return this; }
        @Override public Writer append(CharSequence csq, int start, int end) throws IOException { return this; }
        @Override public Writer append(char c) throws IOException { return this; }
    }
    
    private static Writer createWriter() {
        return new DummyWriter();
    }
    
    private static void useWriter(Writer w) throws IOException {
        w.write('x');
    }
    
    public static void main(String[] args) throws Exception {
        // Variant 2: Inter-procedural - creation and usage split into helper methods
        Writer w = createWriter();
        useWriter(w);
        // No close
    }
}