// Scenario 4: A java.sql.Connection is locally initialized, used directly without storage, has no parent after exemptions, and is not closed.
package scensct.var.pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PosCase4_Var1 {
    public void test() throws SQLException {
        // Variant 1: Split into temporary variable, but still not closed.
        Connection conn = DriverManager.getConnection("jdbc:example:db");
        conn.createStatement(); // [REPORTED LINE]
        // conn not closed
    }
}