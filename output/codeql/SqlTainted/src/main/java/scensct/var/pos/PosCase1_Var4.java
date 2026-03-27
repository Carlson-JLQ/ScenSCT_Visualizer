// A Java method obtains a user-controlled string via HttpServletRequest.getParameter and passes it directly, without sanitization, into Statement.executeQuery to execute a SQL query should be flagged as SQL injection.
package scensct.var.pos;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;

public class PosCase1_Var4 {
    public void vulnerableMethod(HttpServletRequest request, Connection conn) throws Exception {
        // Variant 4: Use String.format for query construction
        String userInput = request.getParameter("username");
        String sql = String.format("SELECT * FROM users WHERE username = '%s'", userInput);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql); // [REPORTED LINE]
    }
}