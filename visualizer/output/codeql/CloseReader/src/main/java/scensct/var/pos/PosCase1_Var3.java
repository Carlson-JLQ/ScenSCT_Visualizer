// FileInputStream created but not closed should be flagged as resource leak.
package scensct.var.pos;

import java.io.FileInputStream;
import java.io.IOException;

public class PosCase1_Var3 {
    public void readFile() throws IOException {
        // Variant 3: Try-catch without finally closing
        try {
            FileInputStream fis = new FileInputStream("test.txt"); // [REPORTED LINE]
            // Not closed
        } catch (IOException e) {
            throw e;
        }
    }
}