// A CloseableInitExpr whose type is not java.sql.Connection, Statement, or ResultSet should not be flagged as unclosed.
package scensct.var.neg;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Paths;

public class NegCase5_Var3 {
    // Variant 3: Inter-procedural - initialization via helper method
    private FileInputStream openFile() throws IOException {
        return new FileInputStream("test.txt");
    }
    
    public void test() throws IOException {
        FileInputStream fis = openFile();
        // Not closed, non-SQL type
    }
}