// A concrete class extending OutputStream, overriding write(int) with a call to a method named "write" inside it, should be flagged as inefficient.
package scensct.var.pos;

import java.io.OutputStream;
import java.io.IOException;

public class PosCase1_Var3 extends OutputStream { // [REPORTED LINE]
    @Override
    public void write(int b) throws IOException {
        try {
            write(new byte[]{(byte) (b & 0xFF)}, 0, 1);
        } catch (IOException e) {
            throw e;
        }
    }
}