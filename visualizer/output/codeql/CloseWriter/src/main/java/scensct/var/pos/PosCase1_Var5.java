// Direct instantiation of FileWriter without closing should be flagged as resource leak.
package scensct.var.pos;

import java.io.FileWriter;
import java.io.IOException;

public class PosCase1_Var5 {
    public void writeToFile() throws IOException {
        // Variant 5: Use a try-finally but without closing in finally (incorrect usage)
        FileWriter writer = new FileWriter("output.txt"); // [REPORTED LINE]
        try {
            writer.write("data");
        } finally {
            // Oops, forgot to close writer here
            // So resource is still leaked
        }
    }
}