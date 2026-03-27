// A CloseableInitExpr whose type is not java.sql.Connection, Statement, or ResultSet should not be flagged as unclosed.
package scensct.core.neg;

import java.io.FileInputStream;
import java.io.IOException;

public class NegCase5 {
    public void test() throws IOException {
        // CloseableInitExpr of type FileInputStream (not SQL resource)
        FileInputStream fis = new FileInputStream("test.txt");
        // This should not trigger the SQL resource checker
    }
}