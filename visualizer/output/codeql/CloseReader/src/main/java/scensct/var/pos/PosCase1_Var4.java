// FileInputStream created but not closed should be flagged as resource leak.
package scensct.var.pos;

import java.io.FileInputStream;
import java.io.IOException;

public class PosCase1_Var4 {
    // Variant 4: Extract creation to a helper method
    private FileInputStream openStream() throws IOException {
        return new FileInputStream("test.txt");
    }

    public void readFile() throws IOException {
        openStream(); // Returned stream is not assigned or closed
    }
}