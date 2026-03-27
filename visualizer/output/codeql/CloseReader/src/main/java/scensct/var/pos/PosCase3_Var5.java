// Wrapper BufferedReader around assigned FileReader not closed should be flagged.
package scensct.var.pos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PosCase3_Var5 {
    public void readWithWrapper() throws IOException {
        // Variant 5: Add irrelevant try-with-resources for distraction, but core pattern unchanged
        try (java.io.StringReader sr = new java.io.StringReader("dummy")) {
            // unrelated resource
        }
        FileReader inner = new FileReader("test.txt"); // [REPORTED LINE]
        BufferedReader wrapper = new BufferedReader(inner);
        // wrapper not closed, inner not closed
    }
}