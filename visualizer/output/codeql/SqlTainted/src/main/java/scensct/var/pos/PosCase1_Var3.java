// A Java method obtains a user-controlled string via HttpServletRequest.getParameter and passes it directly, without sanitization, into Statement.executeQuery to execute a SQL query should be flagged as SQL injection.
package scensct.var.pos;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;

public class PosCase1_Var3 {
    // Variant 3: Extract query building to a helper method
    private String buildQuery(String userInput) {
        return "SELECT * FROM users WHERE username = '" + userInput + "'";
    }

    public void vulnerableMethod(HttpServletRequest request, Connection conn) throws Exception {
        String userInput = request.getParameter("username");
        String sql = buildQuery(userInput);
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql); // [REPORTED LINE]
    }
}