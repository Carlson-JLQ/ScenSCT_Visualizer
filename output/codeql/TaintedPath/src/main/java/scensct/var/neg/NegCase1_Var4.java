// Path operation with only non-tainted sources should not be flagged as path injection.
package scensct.var.neg;

import java.io.File;
import java.nio.file.Paths;

public class NegCase1_Var4 {
    public static void main(String[] args) {
        // Variant 4: idiomatic – using Paths.get with literal, then toFile()
        File file = Paths.get("static", "config.txt").toFile();
        System.out.println(file.exists());
    }
}