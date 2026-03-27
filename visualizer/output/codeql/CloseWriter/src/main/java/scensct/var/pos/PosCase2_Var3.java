// FileOutputStream passed to BufferedOutputStream where inner resource not guaranteed to be closed should be flagged.
package scensct.var.pos;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PosCase2_Var3 {
    public void writeBuffered() throws IOException {
        // Variant 3: Introduce early return that skips close
        FileOutputStream fos = new FileOutputStream("data.bin");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        bos.write(1);
        if (System.currentTimeMillis() > 0) {
            return; // exit without closing
        }
        // Unreachable code, close never called
        bos.close();
    }
}