// Scenario 1: A java.sql.Connection is locally initialized, not assigned, not passed to a local constructor, has no parent, and is not closed.
package scensct.ref.pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PosCase1_FN1 {
    public void test() throws SQLException {
        // Locally initialized Connection, not assigned to a variable, not passed to a local constructor.
        DriverManager.getConnection("jdbc:example:db");
        // No close() call before method exit.
    }
}