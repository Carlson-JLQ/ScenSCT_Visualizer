// A non-parameter file variable is set as world-writable and later read from should be flagged as a security vulnerability.
package scensct.var.pos;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

public class PosCase1_Var2 {
    public static void main(String[] args) throws IOException {
        // Variant 2: Extract world-writable setting and read into separate helper methods
        File target = new File("world_writable.txt");
        makeWorldWritable(target); // [REPORTED LINE]
        readFromFile(target);
    }
    
    private static void makeWorldWritable(File f) throws IOException {
        f.setWritable(true, false);
    }
    
    private static void readFromFile(File f) throws IOException {
        FileInputStream stream = new FileInputStream(f);
        stream.close();
    }
}