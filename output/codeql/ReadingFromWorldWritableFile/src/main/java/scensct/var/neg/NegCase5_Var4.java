// A variable of type File is a method parameter, used in a recognized file read operation, and also set world-writable via a recognized API should not be flagged as world-writable file read.
package scensct.var.neg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class NegCase5_Var4 {
    // Variant 4: Split setWritable across two calls, introduce a temporary boolean.
    public static void processFile(File file) throws IOException {
        boolean worldWritable = true;
        boolean ownerOnly = false;
        file.setWritable(worldWritable, ownerOnly);
        // Read with a loop that does nothing extra
        try (FileInputStream fis = new FileInputStream(file)) {
            while (fis.read() != -1) {
                break; // read only first byte as in original
            }
        }
    }

    public static void main(String[] args) throws IOException {
        processFile(new File("input.txt"));
    }
}