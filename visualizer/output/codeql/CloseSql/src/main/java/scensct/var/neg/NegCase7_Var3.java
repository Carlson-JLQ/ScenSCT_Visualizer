// A locally initialized SQL ResultSet obtained via a method call on a Statement variable, where Statement is a transitive parent closeable resource, should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class NegCase7_Var3 {
    public void test() throws Exception {
        try (Connection conn = DriverManager.getConnection("jdbc:test");
             Statement originalStmt = conn.createStatement()) {
            // Alias the Statement
            Statement stmtAlias = originalStmt;
            // Always-true condition
            if (conn != null) {
                // Locally initialized ResultSet via method call on aliased Statement
                ResultSet rs = stmtAlias.executeQuery("SELECT 1"); // [REPORTED LINE]
            }
        }
    }
}