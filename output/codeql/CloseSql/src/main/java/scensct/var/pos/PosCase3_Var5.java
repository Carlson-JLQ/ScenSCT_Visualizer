// Scenario 3: A java.sql.ResultSet is locally initialized, has no parent after exemptions, and is not closed.
package scensct.var.pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PosCase3_Var5 {
    public void test() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:example:db");
        try {
            Statement stmt = conn.createStatement(); // [REPORTED LINE]
            ResultSet rs = stmt.executeQuery("SELECT 1"); // [REPORTED LINE]
            // No close in try block
        } finally {
            // Still no close on rs (out of scope) or stmt
        }
    }
}