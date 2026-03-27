// Direct instantiation of FileWriter without closing should be flagged as resource leak.
package scensct.var.pos;

import java.io.FileWriter;
import java.io.IOException;

public class PosCase1_Var1 {
    public void writeToFile() throws IOException {
        // Variant 1: Lexical refactoring - split instantiation and assignment, rename variable
        FileWriter fw;
        fw = new FileWriter("output.txt"); // [REPORTED LINE]
        fw.write("data");
        // Still missing close
    }
}