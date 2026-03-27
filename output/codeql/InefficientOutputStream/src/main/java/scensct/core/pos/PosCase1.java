// A concrete class extending OutputStream, overriding write(int) with a call to a method named "write" inside it, should be flagged as inefficient.
package scensct.core.pos;

import java.io.OutputStream;
import java.io.IOException;

public class PosCase1 extends OutputStream { // [REPORTED LINE]
    @Override
    public void write(int b) throws IOException {
        // Inside write(int), there is a call to a method named "write"
        write(new byte[]{(byte) b}, 0, 1); // This calls the inherited three-parameter write method
    }
}