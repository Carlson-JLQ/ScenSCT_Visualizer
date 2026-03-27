// Wrapper BufferedReader around assigned FileReader not closed should be flagged.
package scensct.core.pos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PosCase3 {
    public void readWithWrapper() throws IOException {
        FileReader inner = new FileReader("test.txt"); // Inner closeable assigned // [REPORTED LINE]
        new BufferedReader(inner); // Wrapper created but not assigned or closed
        // inner not closed explicitly
    }
}