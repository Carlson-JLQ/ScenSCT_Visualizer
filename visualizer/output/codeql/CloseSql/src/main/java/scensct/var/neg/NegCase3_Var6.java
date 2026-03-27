// A locally initialized SQL resource with a transitive parent closeable resource associated with a local variable should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class NegCase3_Var6 {
    public void test() throws Exception {
        boolean flag = true;
        if (flag) {
            // The try block is inside a branch, but closure still guaranteed
            try (Connection conn = DriverManager.getConnection("jdbc:test");
                 Statement stmt = conn.createStatement()) {
                // do nothing
            }
        } else {
            // dead branch
        }
    }
}