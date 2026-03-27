// A variable of type Path is never used in any file read operation should not be flagged as world-writable file read.
package scensct.var.neg;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class NegCase2_Var5 {
    // Variant 5: Control-flow with loop and collection, still no read
    public static void main(String[] args) {
        List<Path> paths = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            paths.add(Paths.get("output" + i + ".txt"));
        }
        // Only inspect path properties, never read file content.
        paths.stream()
             .map(Path::toAbsolutePath)
             .forEach(System.out::println);
    }
}