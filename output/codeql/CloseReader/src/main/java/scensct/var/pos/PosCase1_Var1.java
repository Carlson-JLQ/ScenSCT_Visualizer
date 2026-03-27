// FileInputStream created but not closed should be flagged as resource leak.
package scensct.var.pos;

import java.io.FileInputStream;
import java.io.IOException;

public class PosCase1_Var1 {
    public void loadData() throws IOException {
        // Variant 1: Introduce a temporary variable but still no close
        FileInputStream fis = new FileInputStream("test.txt"); // [REPORTED LINE]
        // No close call
    }
}