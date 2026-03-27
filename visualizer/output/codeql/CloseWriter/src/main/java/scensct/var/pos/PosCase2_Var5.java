// FileOutputStream passed to BufferedOutputStream where inner resource not guaranteed to be closed should be flagged.
package scensct.var.pos;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PosCase2_Var5 {
    public void writeBuffered() throws IOException {
        // Variant 5: Wrap in a method that returns the BufferedOutputStream without closing
        BufferedOutputStream bos = openBufferedStream("data.bin");
        bos.write(1);
        // Not closed
    }
    
    private BufferedOutputStream openBufferedStream(String file) throws IOException {
        FileOutputStream fos = new FileOutputStream(file);
        return new BufferedOutputStream(fos);
    }
}