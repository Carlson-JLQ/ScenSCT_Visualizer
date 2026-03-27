// A variable of type File is a method parameter, used in a recognized file read operation, and also set world-writable via a recognized API should not be flagged as world-writable file read.
package scensct.core.neg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class NegCase5 {
    // Method with File parameter; checker does not report on parameters.
    public static void processFile(File file) throws IOException {
        // Recognized world-writable setting: File.setWritable(true, false) makes world-writable.
        file.setWritable(true, false);
        // Recognized read operation: FileInputStream.
        try (FileInputStream fis = new FileInputStream(file)) {
            int data = fis.read();
        }
    }

    public static void main(String[] args) throws IOException {
        processFile(new File("input.txt")); // Inlined creation to avoid variable tracking
    }
}