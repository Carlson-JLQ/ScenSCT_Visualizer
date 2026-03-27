// A variable of type Path is used in a recognized file read operation and is set world-writable via an API not recognized by the checker should not be flagged as world-writable file read.
package scensct.var.neg;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.HashSet;

public class NegCase4_Var3 {
    // Inline the permission setting into a larger helper.
    private static void prepareFile(Path p, boolean flag) throws IOException {
        if (flag) {
            // Still unrecognized: empty HashSet.
            Files.setAttribute(p, "posix:permissions", new HashSet<>());
        }
    }

    private static byte[] readFileContent(Path p) throws IOException {
        // Read moved to separate method.
        return Files.readAllBytes(p);
    }

    public static void main(String[] args) throws IOException {
        Path dataPath = Paths.get("data.txt");
        prepareFile(dataPath, true);
        byte[] content = readFileContent(dataPath);
    }
}