// A non-parameter file variable is set as world-writable and later read from should be flagged as a security vulnerability.
package scensct.core.pos;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

public class PosCase1 {
    public static void main(String[] args) throws IOException {
        // Non-parameter file variable declaration
        File fileVar = new File("world_writable.txt");
        
        // Setting file as world-writable via File.setWritable
        fileVar.setWritable(true, false); // world-writable: true for all, false for others // [REPORTED LINE]
        
        // Later read from the same file variable
        FileInputStream fis = new FileInputStream(fileVar); // Read operation after world-writable setting
        fis.close();
    }
}