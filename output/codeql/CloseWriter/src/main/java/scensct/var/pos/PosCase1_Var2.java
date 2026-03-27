// Direct instantiation of FileWriter without closing should be flagged as resource leak.
package scensct.var.pos;

import java.io.FileWriter;
import java.io.IOException;

public class PosCase1_Var2 {
    public void writeToFile() throws IOException {
        // Variant 2: Control-flow restructuring with a conditional that always executes
        FileWriter writer = null;
        if (true) { // always true, but adds a block
            writer = new FileWriter("output.txt"); // [REPORTED LINE]
            writer.write("data");
        }
        // No close, leak persists
    }
}