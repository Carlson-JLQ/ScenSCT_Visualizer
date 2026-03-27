// A CloseableInitExpr whose type is not java.sql.Connection, Statement, or ResultSet should not be flagged as unclosed.
package scensct.var.neg;

import java.io.FileReader;
import java.io.IOException;

public class NegCase5_Var4 {
    // Variant 4: Idiomatic - switch to another non-SQL Closeable type
    public void test() throws IOException {
        FileReader reader = new FileReader("test.txt");
        // Still not a SQL resource, should not be flagged
    }
}