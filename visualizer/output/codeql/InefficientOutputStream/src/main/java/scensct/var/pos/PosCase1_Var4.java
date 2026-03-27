// A concrete class extending OutputStream, overriding write(int) with a call to a method named "write" inside it, should be flagged as inefficient.
package scensct.var.pos;

import java.io.OutputStream;
import java.io.IOException;

public class PosCase1_Var4 extends OutputStream {
    private void doWrite(byte[] data, int off, int len) throws IOException {
        // This is just a rename; still calls the inherited write
        write(data, off, len);
    }

    @Override
    public void write(int b) throws IOException {
        doWrite(new byte[]{(byte) b}, 0, 1);
    }
}