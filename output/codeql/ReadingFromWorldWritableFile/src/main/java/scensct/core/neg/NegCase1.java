// A variable of type File is used in a recognized file read operation, but the variable is never set world-writable should not be flagged as world-writable file read.
package scensct.core.neg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class NegCase1 {
    public static void main(String[] args) throws IOException {
        File file = new File("data.txt");
        // Scenario: File variable used in recognized read (FileInputStream) but never set world-writable.
        try (FileInputStream fis = new FileInputStream(file)) {
            int data = fis.read();
        }
    }
}