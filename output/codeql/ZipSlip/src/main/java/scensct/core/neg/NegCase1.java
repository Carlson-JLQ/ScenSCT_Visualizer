// Calling getSize() on ZipEntry should not be flagged as unsanitized archive entry name.
package scensct.core.neg;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class NegCase1 {
    public static void main(String[] args) throws IOException {
        // Simulating a ZipInputStream source (not actual reading for minimality)
        ZipInputStream zis = null;
        ZipEntry entry = zis != null ? zis.getNextEntry() : new ZipEntry("test.txt");
        // Scenario 1: Using getSize() method, not getName()
        long size = entry.getSize();
        // Using the size (a long) in a file operation sink argument - should not trigger
        File file = new File("output_" + size + ".dat");
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(0);
        }
    }
}