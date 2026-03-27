// A variable of type Path is used in a recognized file read operation and is set world-writable via an API not recognized by the checker should not be flagged as world-writable file read.
package scensct.var.neg;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.Set;

public class NegCase4_Var1 {
    // Renamed method, still uses unrecognized API.
    private static void adjustPermissions(Path target) throws IOException {
        // Use a different attribute string but same effect.
        Files.setAttribute(target, "posix:permissions", Set.of());
    }

    public static void main(String[] args) throws IOException {
        Path file = Paths.get("data.txt");
        adjustPermissions(file);
        // Read with a different Files method.
        String content = Files.readString(file);
    }
}