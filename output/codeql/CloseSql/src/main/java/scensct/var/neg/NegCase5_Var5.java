// A CloseableInitExpr whose type is not java.sql.Connection, Statement, or ResultSet should not be flagged as unclosed.
package scensct.var.neg;

import java.io.FileInputStream;
import java.io.IOException;

public class NegCase5_Var5 {
    // Variant 5: Control-flow restructuring with early return
    public void test(boolean flag) throws IOException {
        FileInputStream fis = new FileInputStream("test.txt");
        if (flag) {
            return; // early exit, still no close
        }
        // normal path also does not close
    }
}