// Scenario 2: A java.sql.Statement is locally initialized and used directly as a receiver without being stored.
package scensct.var.pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PosCase2_Var5 {
    public void test() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:example:db");
        // Use the statement in a conditional branch, but still not closed
        if (conn != null) {
            conn.createStatement().executeQuery("SELECT 1"); // [REPORTED LINE]
        }
        // No close outside the branch
    }
}