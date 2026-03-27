// FileOutputStream passed to BufferedOutputStream where inner resource not guaranteed to be closed should be flagged.
package scensct.var.pos;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PosCase2_Var4 {
    public void writeBuffered() throws IOException {
        // Variant 4: Use try-finally but close in finally only on exception path
        FileOutputStream fos = new FileOutputStream("data.bin"); // [REPORTED LINE]
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        try {
            bos.write(1);
        } finally {
            // Only close if an exception occurs? Actually no, this finally does nothing.
            // The resource remains open on normal exit.
            // This pattern might confuse simple checkers.
        }
    }
}