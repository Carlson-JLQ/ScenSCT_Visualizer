// A variable of type Path is used in a recognized file read operation and is set world-writable via an API not recognized by the checker should not be flagged as world-writable file read.
package scensct.var.neg;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.IOException;
import java.util.TreeSet;

public class NegCase4_Var5 {
    // Use a different collection type, still empty.
    private static void modifyPermissions(Path path) throws IOException {
        Files.setAttribute(path, "posix:permissions", new TreeSet<>());
    }

    public static void main(String[] args) throws IOException {
        Path theFile = Paths.get("data.txt");
        modifyPermissions(theFile);
        // Read via Files.lines (still a read operation).
        long lineCount = Files.lines(theFile).count();
    }
}