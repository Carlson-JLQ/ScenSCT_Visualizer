// A CloseableInitExpr whose type is not java.sql.Connection, Statement, or ResultSet should not be flagged as unclosed.
package scensct.var.neg;

import java.io.FileInputStream;
import java.io.IOException;

public class NegCase5_Var2 {
    public void test() throws IOException {
        // Variant 2: Intra-procedural - add a try-catch that does not close
        FileInputStream fis = null;
        try {
            fis = new FileInputStream("test.txt");
        } catch (IOException e) {
            throw e;
        }
        // fis still not closed, type unchanged
    }
}