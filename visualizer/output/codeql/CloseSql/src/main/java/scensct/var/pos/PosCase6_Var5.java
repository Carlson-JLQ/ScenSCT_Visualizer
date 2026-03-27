// Scenario 6: A java.sql.ResultSet is locally initialized as a child of a non-locally-initialized Statement parameter, used directly, and not closed.
package scensct.var.pos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PosCase6_Var5 {
    public void test(Statement stmt) throws SQLException {
        Statement s = stmt; // alias
        for (int i = 0; i < 1; i++) {
            s.executeQuery("SELECT 1"); // still not stored or closed // [REPORTED LINE]
        }
    }
}