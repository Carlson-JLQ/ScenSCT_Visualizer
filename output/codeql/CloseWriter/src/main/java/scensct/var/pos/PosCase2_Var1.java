// FileOutputStream passed to BufferedOutputStream where inner resource not guaranteed to be closed should be flagged.
package scensct.var.pos;

import java.io.BufferedOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class PosCase2_Var1 {
    public void writeBuffered() throws IOException {
        // Variant 1: Inline creation, rename variables, add unused temp
        BufferedOutputStream output = new BufferedOutputStream(
            new FileOutputStream("data.bin") // [REPORTED LINE]
        );
        int data = 1;
        output.write(data);
        // Still missing close
    }
}