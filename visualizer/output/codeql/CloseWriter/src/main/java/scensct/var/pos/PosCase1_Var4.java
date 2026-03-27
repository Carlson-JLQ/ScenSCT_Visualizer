// Direct instantiation of FileWriter without closing should be flagged as resource leak.
package scensct.var.pos;

import java.io.FileWriter;
import java.io.IOException;

public class PosCase1_Var4 {
    public void writeToFile() throws IOException {
        // Variant 4: Introduce a temporary variable for the file name, and a loop that runs once
        String filename = "output.txt";
        FileWriter writer = null;
        for (int i = 0; i < 1; i++) {
            writer = new FileWriter(filename); // [REPORTED LINE]
            writer.write("data");
        }
        // No close, leak remains
    }
}