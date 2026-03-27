// A variable of type Path is used in a recognized file read operation and is set world-writable via an API not recognized by the checker should not be flagged as world-writable file read.
package scensct.core.neg;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;

public class NegCase4 {
    // Custom method to set world-writable permissions, not using Files.setPosixFilePermissions.
    private static void setWorldWritableCustom(Path p) throws IOException {
        // Simulate setting permissions without recognized API.
        Files.setAttribute(p, "posix:permissions", java.util.Set.of());
    }

    public static void main(String[] args) throws IOException {
        Path path = Paths.get("data.txt");
        // Scenario: World-writable set via unrecognized API (setWorldWritableCustom).
        setWorldWritableCustom(path);
        // Recognized read operation (Files.readAllBytes).
        byte[] content = Files.readAllBytes(path);
    }
}