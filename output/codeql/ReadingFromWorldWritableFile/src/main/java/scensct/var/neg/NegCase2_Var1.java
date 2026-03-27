// A variable of type Path is never used in any file read operation should not be flagged as world-writable file read.
package scensct.var.neg;

import java.nio.file.Path;
import java.nio.file.Paths;

public class NegCase2_Var1 {
    public static void main(String[] args) {
        // Variant 1: Lexical & control-flow restructuring
        // Introduce a temporary variable and conditional that does not affect the path usage.
        Path p = Paths.get("output.txt");
        boolean debug = args.length > 0;
        if (debug) {
            System.err.println("Debug mode: " + p.normalize());
        } else {
            System.out.println(p.toAbsolutePath());
        }
    }
}