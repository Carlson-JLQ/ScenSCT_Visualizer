// Wrapper BufferedReader around assigned FileReader not closed should be flagged.
package scensct.var.pos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PosCase3_Var3 {
    // Variant 3: Inter-procedural - extract wrapper creation to helper, but helper doesn't close
    private BufferedReader createWrapper(FileReader fr) {
        return new BufferedReader(fr);
    }
    
    public void readWithWrapper() throws IOException {
        FileReader inner = new FileReader("test.txt"); // [REPORTED LINE]
        createWrapper(inner); // wrapper returned but ignored, not closed
        // inner not closed
    }
}