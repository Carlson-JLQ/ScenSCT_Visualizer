// Scenario 5: A java.sql.Statement is locally initialized as a child of a non-locally-initialized Connection parameter, not assigned, and not closed.
package scensct.var.pos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PosCase5_Var3 {
    public void test(Connection conn) throws SQLException {
        // Variant 3: Statement creation via a helper method that returns void, simulating inline usage.
        createAndForget(conn);
    }
    
    private void createAndForget(Connection c) throws SQLException {
        c.createStatement(); // Still locally initialized and not closed. // [REPORTED LINE]
    }
}