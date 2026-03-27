// A variable of type File is used in a recognized file read operation, but the variable is never set world-writable should not be flagged as world-writable file read.
package scensct.var.neg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class NegCase1_Var4 {
    public static void main(String[] args) throws IOException {
        // Variant 4: Wrap read in try-catch-finally without try-with-resources
        File file = new File("data.txt");
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(file);
            fis.read();
        } catch (IOException e) {
            throw e;
        } finally {
            if (fis != null) {
                fis.close();
            }
        }
    }
}