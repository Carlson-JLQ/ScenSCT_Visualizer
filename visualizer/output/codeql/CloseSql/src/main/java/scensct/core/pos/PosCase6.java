// Scenario 6: A java.sql.ResultSet is locally initialized as a child of a non-locally-initialized Statement parameter, used directly, and not closed.
package scensct.core.pos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PosCase6 {
    public void test(Statement stmt) throws SQLException {
        // Child ResultSet locally initialized from parameter Statement, used directly without storage.
        stmt.executeQuery("SELECT 1"); // [REPORTED LINE]
        // No close() call on the ResultSet; parent Statement does not guarantee closure after exemptions.
    }
}