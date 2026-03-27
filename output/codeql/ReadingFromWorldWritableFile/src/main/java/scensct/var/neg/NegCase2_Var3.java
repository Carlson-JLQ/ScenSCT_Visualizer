// A variable of type Path is never used in any file read operation should not be flagged as world-writable file read.
package scensct.var.neg;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.function.Supplier;

public class NegCase2_Var3 {
    // Variant 3: Idiomatic variation with lambda and supplier
    // Path is wrapped in a supplier but never used for reading.
    public static void main(String[] args) {
        Supplier<Path> pathSupplier = () -> Paths.get("output.txt");
        Path resolvedPath = pathSupplier.get().toAbsolutePath();
        System.out.println(resolvedPath);
    }
}