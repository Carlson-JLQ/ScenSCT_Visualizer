// A variable of type Path is never used in any file read operation should not be flagged as world-writable file read.
package scensct.core.neg;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NegCase2 {
    public static void main(String[] args) {
        Path path = Paths.get("output.txt");
        // Scenario: Path variable exists but is never used in a read operation.
        System.out.println(path.toAbsolutePath());
    }
}