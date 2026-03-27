// A variable of type File is used in a file read expression via an API not recognized by the checker should not be flagged as world-writable file read.
package scensct.core.neg;

import java.io.File;
import java.io.IOException;

public class NegCase3 {
    // Custom reader method not matching checker's recognized patterns.
    private static byte[] customRead(File f) throws IOException {
        // Simulate reading without using standard APIs like FileInputStream.
        return new byte[0];
    }

    public static void main(String[] args) throws IOException {
        File file = new File("data.txt");
        // Scenario: Read via unrecognized API (customRead).
        byte[] data = customRead(file);
    }
}