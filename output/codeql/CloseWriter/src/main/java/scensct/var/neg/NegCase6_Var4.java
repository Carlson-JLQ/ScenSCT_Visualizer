// A Writer flowing to another closeable resource without special inner chain should not be flagged.
package scensct.var.neg;

import java.io.Writer;
import java.io.Closeable;
import java.io.IOException;

public class NegCase6_Var4 {
    // Variant 4: Rename class and add a static factory method.
    static class CustomWriterWrapper extends Writer {
        private final Writer innerWriter;
        CustomWriterWrapper(Writer w) { this.innerWriter = w; }
        public static CustomWriterWrapper wrap(Writer w) { return new CustomWriterWrapper(w); }
        public void write(char[] cbuf, int off, int len) throws IOException { innerWriter.write(cbuf, off, len); }
        public void flush() throws IOException { innerWriter.flush(); }
        public void close() throws IOException { innerWriter.close(); }
        public void write(int c) throws IOException { innerWriter.write(c); }
        public void write(String str) throws IOException { innerWriter.write(str); }
        public void write(String str, int off, int len) throws IOException { innerWriter.write(str, off, len); }
        public Writer append(CharSequence csq) throws IOException { return innerWriter.append(csq); }
        public Writer append(CharSequence csq, int start, int end) throws IOException { return innerWriter.append(csq, start, end); }
        public Writer append(char c) throws IOException { return innerWriter.append(c); }
    }
    
    public static void main(String[] args) throws Exception {
        CustomWriterWrapper wrapper = CustomWriterWrapper.wrap(new java.io.StringWriter());
        wrapper.append("flow");
    }
}