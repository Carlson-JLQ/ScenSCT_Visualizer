// Scenario 2: A java.sql.Statement is locally initialized and used directly as a receiver without being stored.
package scensct.var.pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PosCase2_Var2 {
    public void test() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:example:db");
        // Use the statement in a try block without closing, simulating partial handling
        try {
            conn.createStatement().executeQuery("SELECT 1"); // [REPORTED LINE]
        } catch (SQLException e) {
            throw e;
        }
        // Still not closed
    }
}