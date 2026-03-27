// Scenario 5: A java.sql.Statement is locally initialized as a child of a non-locally-initialized Connection parameter, not assigned, and not closed.
package scensct.var.pos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PosCase5_Var1 {
    public void test(Connection conn) throws SQLException {
        // Variant 1: Statement creation inside a try block, still not assigned.
        try {
            conn.createStatement(); // [REPORTED LINE]
        } catch (RuntimeException e) {
            // Unrelated exception handling
            throw new SQLException("Runtime error", e);
        }
        // No close() call.
    }
}