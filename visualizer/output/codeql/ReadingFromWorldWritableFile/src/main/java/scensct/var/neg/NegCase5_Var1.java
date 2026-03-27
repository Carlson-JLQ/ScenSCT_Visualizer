// A variable of type File is a method parameter, used in a recognized file read operation, and also set world-writable via a recognized API should not be flagged as world-writable file read.
package scensct.var.neg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NegCase5_Var1 {
    // Variant 1: Introduce a local alias for the parameter, wrap read in a helper method.
    public static void processFile(File file) throws IOException {
        File target = file; // alias
        target.setWritable(true, false); // [REPORTED LINE]
        readFromFile(target);
    }

    private static void readFromFile(File f) throws IOException {
        try (FileInputStream fis = new FileInputStream(f)) {
            fis.read();
        }
    }

    public static void main(String[] args) throws IOException {
        processFile(new File("input.txt"));
    }
}