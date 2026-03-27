// Scenario 2: A java.sql.Statement is locally initialized and used directly as a receiver without being stored.
package scensct.core.pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class PosCase2 {
    public void test() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:example:db");
        // Locally initialized Statement used directly as receiver, not stored.
        conn.createStatement().executeQuery("SELECT 1"); // [REPORTED LINE]
        // No close() call on the Statement before method exit.
    }
}