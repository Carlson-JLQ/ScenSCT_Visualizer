// Scenario 6: A java.sql.ResultSet is locally initialized as a child of a non-locally-initialized Statement parameter, used directly, and not closed.
package scensct.var.pos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PosCase6_Var4 {
    public void test(Statement stmt) throws SQLException {
        boolean hasResults = stmt.execute("SELECT 1");
        if (hasResults) {
            ResultSet rs = stmt.getResultSet();
            // rs not closed
        }
    }
}