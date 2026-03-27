// A variable of type File is used in a file read expression via an API not recognized by the checker should not be flagged as world-writable file read.
package scensct.var.neg;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;

public class NegCase3_Var5 {
    private static byte[] customRead(File f) throws IOException {
        return new byte[0];
    }

    public static void main(String[] args) throws IOException {
        // Using modern NIO Path, but converting to File for customRead
        File file = Paths.get("data.txt").toFile();
        byte[] data = customRead(file);
    }
}