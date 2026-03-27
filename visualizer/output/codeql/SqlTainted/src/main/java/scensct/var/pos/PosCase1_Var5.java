// A Java method obtains a user-controlled string via HttpServletRequest.getParameter and passes it directly, without sanitization, into Statement.executeQuery to execute a SQL query should be flagged as SQL injection.
package scensct.var.pos;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;

public class PosCase1_Var5 {
    // Variant 5: Extract sink invocation to a helper method, keeping taint flow inter-procedural
    private void executeDynamicQuery(Connection conn, String query) throws Exception {
        Statement stmt = conn.createStatement();
        stmt.executeQuery(query); // [REPORTED LINE]
    }

    public void vulnerableMethod(HttpServletRequest request, Connection conn) throws Exception {
        String userInput = request.getParameter("username");
        String sql = "SELECT * FROM users WHERE username = '" + userInput + "'";
        executeDynamicQuery(conn, sql);
    }
}