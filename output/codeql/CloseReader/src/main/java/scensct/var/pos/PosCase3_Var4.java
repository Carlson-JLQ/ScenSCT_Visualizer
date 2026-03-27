// Wrapper BufferedReader around assigned FileReader not closed should be flagged.
package scensct.var.pos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class PosCase3_Var4 {
    public void readWithWrapper() throws IOException {
        // Variant 4: Equivalent API - use FileInputStream + InputStreamReader instead of FileReader
        // but still wrapped by BufferedReader
        java.io.FileInputStream fis = new java.io.FileInputStream("test.txt"); // [REPORTED LINE]
        java.io.InputStreamReader isr = new java.io.InputStreamReader(fis);
        new BufferedReader(isr); // wrapper not closed, underlying chain not closed
        // fis and isr not closed
    }
}