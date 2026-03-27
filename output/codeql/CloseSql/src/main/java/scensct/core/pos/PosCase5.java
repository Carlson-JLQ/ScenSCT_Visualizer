// Scenario 5: A java.sql.Statement is locally initialized as a child of a non-locally-initialized Connection parameter, not assigned, and not closed.
package scensct.core.pos;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class PosCase5 {
    public void test(Connection conn) throws SQLException {
        // Child Statement locally initialized from parameter Connection, not assigned.
        conn.createStatement(); // [REPORTED LINE]
        // No close() call on the Statement; parent Connection does not guarantee closure.
    }
}