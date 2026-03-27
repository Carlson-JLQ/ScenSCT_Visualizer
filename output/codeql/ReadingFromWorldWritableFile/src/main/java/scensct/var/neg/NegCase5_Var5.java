// A variable of type File is a method parameter, used in a recognized file read operation, and also set world-writable via a recognized API should not be flagged as world-writable file read.
package scensct.var.neg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class NegCase5_Var5 {
    // Variant 5: Extract the world-writable setting to a helper that returns the same file, keep parameter.
    public static void processFile(File file) throws IOException {
        File processed = makeWorldWritable(file);
        try (FileInputStream fis = new FileInputStream(processed)) {
            fis.read();
        }
    }

    private static File makeWorldWritable(File f) {
        f.setWritable(true, false);
        return f;
    }

    public static void main(String[] args) throws IOException {
        processFile(new File("input.txt"));
    }
}