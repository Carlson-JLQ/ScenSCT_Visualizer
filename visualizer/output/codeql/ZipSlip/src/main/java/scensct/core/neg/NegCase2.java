// Calling getName() on a custom class not inheriting from ZipEntry/ArchiveEntry should not be flagged.
package scensct.core.neg;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

// Custom class with getName() method, unrelated to archive entries
class CustomEntry {
    private String name;
    public CustomEntry(String name) { this.name = name; }
    public String getName() { return name; }
}

public class NegCase2 {
    public static void main(String[] args) throws IOException {
        CustomEntry entry = new CustomEntry("test.txt");
        // Scenario 2: getName() from a non-archive entry type
        String name = entry.getName();
        // Flow to file operation sink - should not trigger because source is not ZipEntry/ArchiveEntry
        File file = new File("dir/" + name);
        try (FileOutputStream fos = new FileOutputStream(file)) {
            fos.write(0);
        }
    }
}