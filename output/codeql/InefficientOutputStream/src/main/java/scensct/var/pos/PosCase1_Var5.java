// A concrete class extending OutputStream, overriding write(int) with a call to a method named "write" inside it, should be flagged as inefficient.
package scensct.var.pos;

import java.io.OutputStream;
import java.io.IOException;
import java.util.Arrays;

public class PosCase1_Var5 extends OutputStream { // [REPORTED LINE]
    @Override
    public void write(int b) throws IOException {
        byte[] arr = new byte[1];
        arr[0] = (byte) b;
        write(arr, 0, arr.length);
    }
}