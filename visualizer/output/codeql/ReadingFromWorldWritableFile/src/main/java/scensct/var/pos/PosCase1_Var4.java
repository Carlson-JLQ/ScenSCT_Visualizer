// A non-parameter file variable is set as world-writable and later read from should be flagged as a security vulnerability.
package scensct.var.pos;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

public class PosCase1_Var4 {
    public static void main(String[] args) throws IOException {
        // Variant 4: Loop that executes exactly once
        File fileVar = null;
        for (int i = 0; i < 1; i++) {
            fileVar = new File("world_writable.txt");
            fileVar.setWritable(true, false); // [REPORTED LINE]
        }
        // Read after loop
        FileInputStream fis = new FileInputStream(fileVar);
        fis.read();
        fis.close();
    }
}