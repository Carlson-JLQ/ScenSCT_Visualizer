// A CloseableInitExpr whose type is not java.sql.Connection, Statement, or ResultSet should not be flagged as unclosed.
package scensct.var.neg;

import java.io.FileInputStream;
import java.io.IOException;

public class NegCase5_Var1 {
    public void test() throws IOException {
        // Variant 1: Lexical refactoring - rename, change constructor argument
        FileInputStream inputStream = new FileInputStream("data.bin");
        // No close, still non-SQL type
    }
}