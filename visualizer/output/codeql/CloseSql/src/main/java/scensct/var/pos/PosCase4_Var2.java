// Scenario 4: A java.sql.Connection is locally initialized, used directly without storage, has no parent after exemptions, and is not closed.
package scensct.var.pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PosCase4_Var2 {
    public void test() throws SQLException {
        // Variant 2: Use a static helper to obtain the Connection, but still use locally and not close.
        Connection c = getConnection();
        c.createStatement(); // [REPORTED LINE]
    }
    
    private static Connection getConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:example:db");
    }
}