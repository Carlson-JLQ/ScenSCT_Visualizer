// A variable of type Path is never used in any file read operation should not be flagged as world-writable file read.
package scensct.var.neg;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileTime;
import java.time.Instant;

public class NegCase2_Var4 {
    // Variant 4: Add unrelated file attribute operation (write metadata, not read content)
    public static void main(String[] args) throws java.io.IOException {
        Path target = Paths.get("output.txt").toAbsolutePath();
        // Simulate setting last modified time (requires file to exist, but not reading).
        // This is a file system operation that does not read file content.
        java.nio.file.Files.setLastModifiedTime(target, FileTime.from(Instant.now()));
        System.out.println("Updated timestamp for: " + target);
    }
}