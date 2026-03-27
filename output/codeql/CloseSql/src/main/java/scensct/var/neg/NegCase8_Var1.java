// A locally initialized SQL resource constructed with an argument that is a Servlet response/request stream getter method call should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class NegCase8_Var1 {
    static class MockResponse {
        PrintWriter getWriter() { return new PrintWriter(System.out); }
    }
    
    public void test(HttpServletResponse response) throws Exception {
        // Variant 1: Stream getter call directly in expression, SQL resource after
        Connection conn = DriverManager.getConnection("jdbc:test", "user", "pass");
        response.getWriter(); // Call ignored but present
    }
}