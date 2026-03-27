// Direct usage of ZipEntry.getName() as a path component in File constructor without sanitization should be flagged as Zip Slip vulnerability.
package scensct.core.pos;

import java.io.File;
import java.util.zip.ZipEntry;

public class PosCase1 {
    public void extractEntry(File parentDir, ZipEntry entry) {
        String entryName = entry.getName(); // Retrieve unsanitized entry name
        File targetFile = new File(parentDir.getPath() + File.separator + entryName); // Direct concatenation into File constructor
        // ... (extraction logic would follow)
    }
}