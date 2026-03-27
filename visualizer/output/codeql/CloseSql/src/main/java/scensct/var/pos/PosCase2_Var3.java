// Scenario 2: A java.sql.Statement is locally initialized and used directly as a receiver without being stored.
package scensct.var.pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PosCase2_Var3 {
    public void test() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:example:db");
        // Extract the statement creation and usage into a private helper method
        executeWithStatement(conn);
        // Helper does not close the statement
    }

    private void executeWithStatement(Connection conn) throws SQLException {
        conn.createStatement().executeQuery("SELECT 1"); // [REPORTED LINE]
    }
}