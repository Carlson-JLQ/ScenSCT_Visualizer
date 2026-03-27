// Direct instantiation of FileWriter without closing should be flagged as resource leak.
package scensct.var.pos;

import java.io.FileWriter;
import java.io.IOException;

public class PosCase1_Var3 {
    // Variant 3: Inter-procedural - extract writer usage to a helper, but leak remains in caller
    private void doWrite(FileWriter w) throws IOException {
        w.write("data");
        // Not closing here; responsibility is with caller
    }
    
    public void writeToFile() throws IOException {
        FileWriter writer = new FileWriter("output.txt"); // [REPORTED LINE]
        doWrite(writer);
        // Missing close
    }
}