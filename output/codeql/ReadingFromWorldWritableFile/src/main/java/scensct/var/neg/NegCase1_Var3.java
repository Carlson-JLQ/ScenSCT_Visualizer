// A variable of type File is used in a recognized file read operation, but the variable is never set world-writable should not be flagged as world-writable file read.
package scensct.var.neg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class NegCase1_Var3 {
    // Variant 3: Extract file creation to a helper method
    private static File createDataFile() {
        return new File("data.txt");
    }

    public static void main(String[] args) throws IOException {
        File f = createDataFile();
        try (FileInputStream in = new FileInputStream(f)) {
            in.read();
        }
    }
}