// Scenario 6: A java.sql.ResultSet is locally initialized as a child of a non-locally-initialized Statement parameter, used directly, and not closed.
package scensct.var.pos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PosCase6_Var2 {
    public void test(Statement stmt) throws SQLException {
        try {
            ResultSet rs = stmt.executeQuery("SELECT 1"); // [REPORTED LINE]
            int x = rs.getInt(1); // use it
        } catch (SQLException e) {
            throw e;
        } finally {
            // Not closing the ResultSet here
        }
    }
}