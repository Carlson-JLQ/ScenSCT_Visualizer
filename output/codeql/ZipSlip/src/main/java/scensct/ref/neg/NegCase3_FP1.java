// Calling getName() on ZipEntry with sanitization (removing "..") should not be flagged.
package scensct.ref.neg;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class NegCase3_FP1 {
    // Simple sanitizer that removes directory traversal sequences
    private static String sanitize(String path) {
        if (path == null) return "";
        // Remove all occurrences of ".." to prevent traversal
        return path.replace("..", "");
    }

    public static void main(String[] args) throws IOException {
        ZipInputStream zis = null;
        ZipEntry entry = zis != null ? zis.getNextEntry() : new ZipEntry("../../evil.txt");
        // Scenario 3: getName() from ZipEntry, but sanitized before sink
        String rawName = entry.getName(); // [REPORTED LINE]
        String safeName = sanitize(rawName); // Sanitization prevents traversal
        // Flow to file operation sink with sanitized name - should not trigger
        File file = new File("base/" + safeName);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(0);
        }
    }
}