// Scenario 6: A java.sql.ResultSet is locally initialized as a child of a non-locally-initialized Statement parameter, used directly, and not closed.
package scensct.var.pos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PosCase6_Var1 {
    public void test(Statement stmt) throws SQLException {
        // Store the ResultSet temporarily but still don't close it
        ResultSet rs = stmt.executeQuery("SELECT 1"); // [REPORTED LINE]
        if (rs.next()) {
            // just a usage, no close
        }
        // rs goes out of scope without close
    }
}