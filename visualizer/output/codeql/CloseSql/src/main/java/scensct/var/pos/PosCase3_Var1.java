// Scenario 3: A java.sql.ResultSet is locally initialized, has no parent after exemptions, and is not closed.
package scensct.var.pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PosCase3_Var1 {
    public void test() throws SQLException {
        Connection c = DriverManager.getConnection("jdbc:example:db");
        Statement s = c.createStatement(); // [REPORTED LINE]
        // Split assignment and introduce a temporary
        String query = "SELECT 1";
        ResultSet result = s.executeQuery(query); // [REPORTED LINE]
        // No close on result
    }
}