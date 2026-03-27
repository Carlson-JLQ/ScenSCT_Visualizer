// Scenario 2: A java.sql.Statement is locally initialized and used directly as a receiver without being stored.
package scensct.var.pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PosCase2_Var1 {
    public void test() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:example:db");
        // Split the chain into a temporary variable, but still use it directly as receiver
        Statement stmt = conn.createStatement(); // [REPORTED LINE]
        stmt.executeQuery("SELECT 1"); // [REPORTED LINE]
        // No close() call
    }
}