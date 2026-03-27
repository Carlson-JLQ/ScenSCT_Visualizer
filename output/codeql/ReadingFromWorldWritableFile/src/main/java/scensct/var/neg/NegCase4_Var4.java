// A variable of type Path is used in a recognized file read operation and is set world-writable via an API not recognized by the checker should not be flagged as world-writable file read.
package scensct.var.neg;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Set;

public class NegCase4_Var4 {
    // Permission setting split into two steps.
    private static void setPerms(Path p) throws IOException {
        Set<?> empty = Set.of();
        Files.setAttribute(p, "posix:permissions", empty);
    }

    public static void main(String[] args) throws IOException {
        Path p = Paths.get("data.txt");
        setPerms(p);
        // Use Files.newInputStream for reading.
        try (var is = Files.newInputStream(p)) {
            byte[] content = is.readAllBytes();
        }
    }
}