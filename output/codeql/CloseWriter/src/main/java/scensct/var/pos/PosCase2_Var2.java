// FileOutputStream passed to BufferedOutputStream where inner resource not guaranteed to be closed should be flagged.
package scensct.var.pos;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PosCase2_Var2 {
    public void writeBuffered() throws IOException {
        // Variant 2: Extract creation to helper, but helper does not close
        FileOutputStream fos = createStream("data.bin");
        BufferedOutputStream bos = new BufferedOutputStream(fos); // [REPORTED LINE]
        bos.write(1);
        // Missing close
    }
    
    private FileOutputStream createStream(String file) throws IOException {
        return new FileOutputStream(file);
    }
}