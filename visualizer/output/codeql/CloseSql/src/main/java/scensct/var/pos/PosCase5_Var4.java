// Scenario 5: A java.sql.Statement is locally initialized as a child of a non-locally-initialized Connection parameter, not assigned, and not closed.
package scensct.var.pos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PosCase5_Var4 {
    public void test(Connection conn) throws SQLException {
        // Variant 4: Statement creation wrapped in a temporary variable that is immediately shadowed/unused.
        Statement stmt = conn.createStatement(); // [REPORTED LINE]
        stmt = null; // Explicitly discard reference, but no close().
        // Checker must recognize the resource is still not closed.
    }
}