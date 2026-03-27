// Wrapper BufferedReader around assigned FileReader not closed should be flagged.
package scensct.var.pos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PosCase3_Var1 {
    public void readWithWrapper() throws IOException {
        // Variant 1: Lexical refactoring - split wrapper creation across lines, rename variable
        FileReader baseReader = new FileReader("test.txt"); // [REPORTED LINE]
        BufferedReader temp = new BufferedReader(baseReader);
        // wrapper not closed, baseReader not closed
    }
}