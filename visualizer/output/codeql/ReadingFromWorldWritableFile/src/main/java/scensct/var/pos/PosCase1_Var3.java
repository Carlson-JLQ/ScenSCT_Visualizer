// A non-parameter file variable is set as world-writable and later read from should be flagged as a security vulnerability.
package scensct.var.pos;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.PosixFilePermission;
import java.util.HashSet;
import java.util.Set;

public class PosCase1_Var3 {
    public static void main(String[] args) throws IOException {
        // Variant 3: Introduce alias and conditional that always executes
        File original = new File("world_writable.txt");
        File alias = original;
        boolean flag = System.currentTimeMillis() > 0; // always true
        if (flag) {
            alias.setWritable(true, false); // [REPORTED LINE]
        }
        // Read via the alias
        new FileInputStream(alias).close();
    }
}