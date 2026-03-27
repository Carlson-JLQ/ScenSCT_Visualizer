// A Java method obtains a user-controlled string via HttpServletRequest.getParameter and passes it directly, without sanitization, into Statement.executeQuery to execute a SQL query should be flagged as SQL injection.
package scensct.core.pos;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;

public class PosCase1 {
    public void vulnerableMethod(HttpServletRequest request, Connection conn) throws Exception {
        // User-controlled input from request parameter
        String userInput = request.getParameter("username");
        // Direct concatenation into SQL query without sanitization
        String sql = "SELECT * FROM users WHERE username = '" + userInput + "'";
        Statement stmt = conn.createStatement();
        // Unsanitized user input flows into executeQuery sink
        ResultSet rs = stmt.executeQuery(sql); // [REPORTED LINE]
    }
}