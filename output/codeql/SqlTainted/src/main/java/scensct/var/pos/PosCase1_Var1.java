// A Java method obtains a user-controlled string via HttpServletRequest.getParameter and passes it directly, without sanitization, into Statement.executeQuery to execute a SQL query should be flagged as SQL injection.
package scensct.var.pos;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javax.servlet.http.HttpServletRequest;

public class PosCase1_Var1 {
    public void vulnerableMethod(HttpServletRequest request, Connection conn) throws Exception {
        // Variant 1: Use StringBuilder for query construction
        String input = request.getParameter("username");
        StringBuilder queryBuilder = new StringBuilder("SELECT * FROM users WHERE username = '");
        queryBuilder.append(input);
        queryBuilder.append("'");
        String sql = queryBuilder.toString();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql); // [REPORTED LINE]
    }
}