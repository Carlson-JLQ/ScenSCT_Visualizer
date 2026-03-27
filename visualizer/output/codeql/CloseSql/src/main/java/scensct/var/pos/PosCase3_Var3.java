// Scenario 3: A java.sql.ResultSet is locally initialized, has no parent after exemptions, and is not closed.
package scensct.var.pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PosCase3_Var3 {
    private ResultSet makeResultSet(Statement s) throws SQLException {
        return s.executeQuery("SELECT 1");
    }

    public void test() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:example:db");
        Statement stmt = conn.createStatement(); // [REPORTED LINE]
        // ResultSet initialized via helper, still locally held and unclosed
        ResultSet rs = makeResultSet(stmt);
    }
}