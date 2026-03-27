// A variable of type File is used in a recognized file read operation, but the variable is never set world-writable should not be flagged as world-writable file read.
package scensct.var.neg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class NegCase1_Var5 {
    public static void main(String[] args) throws IOException {
        // Variant 5: Use Files.newInputStream with Path, still no world-writable
        Path path = Path.of("data.txt");
        try (var is = Files.newInputStream(path)) {
            is.read();
        }
    }
}