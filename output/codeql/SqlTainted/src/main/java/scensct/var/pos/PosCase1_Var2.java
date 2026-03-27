// A Java method obtains a user-controlled string via HttpServletRequest.getParameter and passes it directly, without sanitization, into Statement.executeQuery to execute a SQL query should be flagged as SQL injection.
package scensct.var.pos;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;

public class PosCase1_Var2 {
    public void vulnerableMethod(HttpServletRequest request, Connection conn) throws Exception {
        // Variant 2: Split concatenation across multiple statements with intermediate variable
        String userInput = request.getParameter("username");
        String baseQuery = "SELECT * FROM users WHERE username = '";
        String endQuote = "'";
        String sql = baseQuery + userInput + endQuote;
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery(sql); // [REPORTED LINE]
        }
    }
}