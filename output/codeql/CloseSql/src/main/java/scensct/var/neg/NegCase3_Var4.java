// A locally initialized SQL resource with a transitive parent closeable resource associated with a local variable should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class NegCase3_Var4 {
    private Statement makeStatement(Connection c) throws Exception {
        return c.createStatement();
    }

    public void test() throws Exception {
        try (Connection conn = DriverManager.getConnection("jdbc:test");
             Statement stmt = makeStatement(conn)) {
            // stmt still closed via conn
        }
    }
}