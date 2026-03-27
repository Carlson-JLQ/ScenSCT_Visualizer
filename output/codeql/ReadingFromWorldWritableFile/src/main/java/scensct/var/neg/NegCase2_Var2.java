// A variable of type Path is never used in any file read operation should not be flagged as world-writable file read.
package scensct.var.neg;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.io.IOException;

public class NegCase2_Var2 {
    // Variant 2: Inter-procedural refactoring
    // Move path creation and usage to a helper method, but still no read operation.
    private static void logPathInfo(Path path) {
        System.out.println("Path absolute: " + path.toAbsolutePath());
    }

    public static void main(String[] args) throws IOException {
        Path filePath = Paths.get(System.getProperty("user.dir"), "output.txt");
        // Perform a file operation unrelated to the path variable (create an empty file)
        Files.deleteIfExists(Paths.get("temp.txt"));
        logPathInfo(filePath);
    }
}