// A locally initialized SQL resource constructed with an argument that is a Servlet response/request stream getter method call should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class NegCase8_Var2 {
    static class MockResponse {
        PrintWriter getWriter() { return new PrintWriter(System.out); }
    }
    
    public void test(HttpServletResponse response) throws Exception {
        // Variant 2: Stream getter assigned to a field, then SQL resource
        PrintWriter writer = obtainWriter(response);
        Connection conn = DriverManager.getConnection("jdbc:test", "user", "pass");
    }
    
    private PrintWriter obtainWriter(HttpServletResponse resp) throws Exception {
        return resp.getWriter();
    }
}