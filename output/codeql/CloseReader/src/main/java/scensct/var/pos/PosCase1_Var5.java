// FileInputStream created but not closed should be flagged as resource leak.
package scensct.var.pos;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class PosCase1_Var5 {
    // Variant 5: Use Files.newInputStream (still an InputStream)
    public void readFile() throws IOException {
        Files.newInputStream(Paths.get("test.txt"));
        // Not closed
    }
}