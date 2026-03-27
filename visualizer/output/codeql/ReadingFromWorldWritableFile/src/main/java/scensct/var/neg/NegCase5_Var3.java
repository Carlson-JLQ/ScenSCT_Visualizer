// A variable of type File is a method parameter, used in a recognized file read operation, and also set world-writable via a recognized API should not be flagged as world-writable file read.
package scensct.var.neg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class NegCase5_Var3 {
    // Variant 3: Inline the main call into a static initializer, add a dummy try-catch-finally.
    static {
        try {
            processFile(new File("input.txt"));
        } catch (IOException e) {
            // ignore in test
        }
    }

    public static void processFile(File file) throws IOException {
        file.setWritable(true, false);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            fis.read();
        } finally {
            if (fis != null) fis.close();
        }
    }

    public static void main(String[] args) throws IOException {
        // empty; execution already triggered by static block
    }
}