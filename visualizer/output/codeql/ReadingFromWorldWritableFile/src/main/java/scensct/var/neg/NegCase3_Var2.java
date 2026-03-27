// A variable of type File is used in a file read expression via an API not recognized by the checker should not be flagged as world-writable file read.
package scensct.var.neg;

import java.io.File;
import java.io.IOException;

public class NegCase3_Var2 {
    private static byte[] customRead(File f) throws IOException {
        return new byte[0];
    }

    private static File createFile(String name) {
        return new File(name);
    }

    private static void processFile(File f) throws IOException {
        byte[] content = customRead(f);
        // dummy usage
        if (content.length == 0) {
            return;
        }
    }

    public static void main(String[] args) throws IOException {
        File f = createFile("data.txt");
        processFile(f);
    }
}