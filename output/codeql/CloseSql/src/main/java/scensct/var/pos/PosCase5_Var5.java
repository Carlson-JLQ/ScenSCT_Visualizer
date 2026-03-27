// Scenario 5: A java.sql.Statement is locally initialized as a child of a non-locally-initialized Connection parameter, not assigned, and not closed.
package scensct.var.pos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PosCase5_Var5 {
    public void test(Connection conn) throws SQLException {
        // Variant 5: Statement creation inside a loop, still not assigned.
        for (int i = 0; i < 1; i++) {
            conn.createStatement(); // [REPORTED LINE]
            break; // Ensure only one creation.
        }
        // No close() call.
    }
}