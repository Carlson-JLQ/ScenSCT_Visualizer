// A locally initialized FileInputStream that escapes via return should not be flagged as a leak.
package scensct.var.neg;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.IOException;

public class NegCase5_Var1 {
    // Variant 1: Lexical refactoring - rename variable and use direct return with initialization.
    public InputStream test() throws IOException {
        // Resource created and returned directly, escaping clearly.
        return new FileInputStream("test.txt");
    }
}