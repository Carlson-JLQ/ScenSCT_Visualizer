// A non-parameter file variable is set as world-writable and later read from should be flagged as a security vulnerability.
package scensct.var.pos;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

public class PosCase1_Var5 {
    public static void main(String[] args) throws IOException {
        // Variant 5: Use temporary variable and try-catch-finally
        File fileVar = new File("world_writable.txt");
        File temp = fileVar;
        try {
            temp.setWritable(true, false); // [REPORTED LINE]
        } finally {
            // Read in finally block (always executes if no exception)
            FileInputStream fis = new FileInputStream(temp);
            fis.close();
        }
    }
}