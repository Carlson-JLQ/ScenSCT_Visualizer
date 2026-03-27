// Scenario 5: A java.sql.Statement is locally initialized as a child of a non-locally-initialized Connection parameter, not assigned, and not closed.
package scensct.var.pos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PosCase5_Var2 {
    public void test(Connection conn) throws SQLException {
        // Variant 2: Statement creation as part of a conditional expression, still not assigned.
        if (conn != null) {
            conn.createStatement(); // [REPORTED LINE]
        } else {
            // Dead branch, but preserves control flow complexity.
            return;
        }
        // No close() call.
    }
}