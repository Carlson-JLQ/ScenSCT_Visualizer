// Wrapper BufferedReader around assigned FileReader not closed should be flagged.
package scensct.var.pos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PosCase3_Var2 {
    public void readWithWrapper() throws IOException {
        // Variant 2: Control flow restructuring - wrapper creation inside if(true) block
        FileReader inner = new FileReader("test.txt"); // [REPORTED LINE]
        if (true) {
            new BufferedReader(inner); // still not closed
        }
        // inner not closed
    }
}