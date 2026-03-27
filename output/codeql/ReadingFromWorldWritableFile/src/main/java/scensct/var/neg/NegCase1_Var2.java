// A variable of type File is used in a recognized file read operation, but the variable is never set world-writable should not be flagged as world-writable file read.
package scensct.var.neg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class NegCase1_Var2 {
    public static void main(String[] args) throws IOException {
        // Variant 2: Introduce a temporary variable and conditional that does not affect world-writable property
        String fileName = "data.txt";
        File target = new File(fileName);
        boolean exists = target.exists();
        if (exists) {
            // Still just reading, no world-writable call
            try (FileInputStream fis = new FileInputStream(target)) {
                fis.read();
            }
        } else {
            // Alternative path still only reads (though file doesn't exist)
            System.out.println("File not found: " + fileName);
        }
    }
}