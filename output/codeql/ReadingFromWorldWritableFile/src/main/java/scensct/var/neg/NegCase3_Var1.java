// A variable of type File is used in a file read expression via an API not recognized by the checker should not be flagged as world-writable file read.
package scensct.var.neg;

import java.io.File;
import java.io.IOException;

public class NegCase3_Var1 {
    private static byte[] customRead(File f) throws IOException {
        return new byte[0];
    }

    public static void main(String[] args) throws IOException {
        String fileName = "data.txt";
        File file = new File(fileName);
        if (file.exists() || !file.exists()) { // tautology, always true
            byte[] data = customRead(file);
            System.out.println("Read " + data.length + " bytes");
        }
    }
}