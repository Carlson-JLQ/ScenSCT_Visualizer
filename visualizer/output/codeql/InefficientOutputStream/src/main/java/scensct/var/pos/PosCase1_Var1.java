// A concrete class extending OutputStream, overriding write(int) with a call to a method named "write" inside it, should be flagged as inefficient.
package scensct.var.pos;

import java.io.OutputStream;
import java.io.IOException;

public class PosCase1_Var1 extends OutputStream { // [REPORTED LINE]
    @Override
    public void write(int b) throws IOException {
        byte[] singleByte = new byte[]{(byte) b};
        write(singleByte, 0, 1);
    }
}