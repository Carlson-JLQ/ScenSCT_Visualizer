// FileOutputStream passed to BufferedOutputStream where inner resource not guaranteed to be closed should be flagged.
package scensct.core.pos;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PosCase2 {
    public void writeBuffered() throws IOException {
        // Instantiate OutputStream subclass (FileOutputStream) and pass to BufferedOutputStream
        FileOutputStream fos = new FileOutputStream("data.bin"); // [REPORTED LINE]
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        bos.write(1);
        // Missing bos.close() - inner FileOutputStream not guaranteed to be closed
    }
}