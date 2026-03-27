// Direct instantiation of FileWriter without closing should be flagged as resource leak.
package scensct.core.pos;

import java.io.FileWriter;
import java.io.IOException;

public class PosCase1 {
    public void writeToFile() throws IOException {
        // Direct instantiation of Writer subclass (FileWriter) without closing
        FileWriter writer = new FileWriter("output.txt"); // [REPORTED LINE]
        writer.write("data");
        // Missing writer.close() - resource not guaranteed to be closed
    }
}