// FileInputStream created but not closed should be flagged as resource leak.
package scensct.var.pos;

import java.io.FileInputStream;
import java.io.IOException;

public class PosCase1_Var2 {
    public void readFile() throws IOException {
        // Variant 2: Wrap instantiation in a conditional branch
        if (System.currentTimeMillis() % 2 == 0) {
            new FileInputStream("test.txt"); // [REPORTED LINE]
        } else {
            // No stream in else branch
        }
    }
}