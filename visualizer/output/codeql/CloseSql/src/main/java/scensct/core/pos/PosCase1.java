// Scenario 1: A java.sql.Connection is locally initialized, not assigned, not passed to a local constructor, has no parent, and is not closed.
package scensct.core.pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PosCase1 {
    public void test() throws SQLException {
        // Locally initialized Connection, assigned to a variable but not closed.
        Connection conn = DriverManager.getConnection("jdbc:example:db");
        // No close() call before method exit.
    }
}