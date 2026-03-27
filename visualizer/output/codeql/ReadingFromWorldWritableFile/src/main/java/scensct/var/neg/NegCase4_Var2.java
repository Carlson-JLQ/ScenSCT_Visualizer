// A variable of type Path is used in a recognized file read operation and is set world-writable via an API not recognized by the checker should not be flagged as world-writable file read.
package scensct.var.neg;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Collections;

public class NegCase4_Var2 {
    private static void makeWorldWritable(Path p) throws IOException {
        // Use a static imported empty set, same unrecognized API.
        Files.setAttribute(p, "posix:permissions", Collections.emptySet());
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(System.getProperty("user.dir")).resolve("data.txt");
        makeWorldWritable(path);
        // Wrap read in a try-catch but still reachable.
        try {
            byte[] data = Files.readAllBytes(path);
        } catch (IOException e) {
            throw e;
        }
    }
}