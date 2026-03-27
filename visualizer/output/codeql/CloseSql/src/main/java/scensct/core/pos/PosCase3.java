// Scenario 3: A java.sql.ResultSet is locally initialized, has no parent after exemptions, and is not closed.
package scensct.core.pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PosCase3 {
    public void test() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:example:db");
        Statement stmt = conn.createStatement(); // [REPORTED LINE]
        // Locally initialized ResultSet, no parent closeable resource after exemptions.
        ResultSet rs = stmt.executeQuery("SELECT 1"); // [REPORTED LINE]
        // No close() call on the ResultSet before method exit.
    }
}