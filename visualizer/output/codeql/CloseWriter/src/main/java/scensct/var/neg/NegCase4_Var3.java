// A Writer flowing into a locally initialized closeable resource with empty close should not be flagged.
package scensct.var.neg;

import java.io.Writer;
import java.io.Closeable;
import java.io.IOException;

public class NegCase4_Var3 {
    static class EmptyCloseWriter extends Writer {
        public void write(char[] cbuf, int off, int len) throws IOException { }
        public void flush() throws IOException { }
        public void close() throws IOException { } // Empty
        public void write(int c) throws IOException { }
        public void write(String str) throws IOException { }
        public void write(String str, int off, int len) throws IOException { }
        public Writer append(CharSequence csq) throws IOException { return this; }
        public Writer append(CharSequence csq, int start, int end) throws IOException { return this; }
        public Writer append(char c) throws IOException { return this; }
    }
    
    public static void main(String[] args) throws Exception {
        // Variant 3: Intra-procedural - control flow with branch, but always empty close
        Writer writer = null;
        if (args.length > 0) {
            writer = new EmptyCloseWriter();
        } else {
            writer = new EmptyCloseWriter();
        }
        writer.write("test");
        // No close in either branch
    }
}