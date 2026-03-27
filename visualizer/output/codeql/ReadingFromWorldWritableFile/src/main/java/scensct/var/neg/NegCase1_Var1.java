// A variable of type File is used in a recognized file read operation, but the variable is never set world-writable should not be flagged as world-writable file read.
package scensct.var.neg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;

public class NegCase1_Var1 {
    public static void main(String[] args) throws IOException {
        // Variant 1: Use Paths.get().toFile() instead of direct File constructor
        File dataFile = Paths.get("data.txt").toFile();
        try (FileInputStream input = new FileInputStream(dataFile)) {
            int byteData = input.read();
        }
    }
}