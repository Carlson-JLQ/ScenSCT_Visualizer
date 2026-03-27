// A locally initialized SQL resource constructed with an argument that is a Servlet response/request stream getter method call should not be flagged as unclosed.
package scensct.core.neg;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class NegCase8 {
    // Placeholder for Servlet response
    static class MockResponse {
        PrintWriter getWriter() { return new PrintWriter(System.out); }
    }
    
    public void test(HttpServletResponse response) throws Exception {
        // Argument is a stream getter method call (getWriter)
        PrintWriter writer = response.getWriter();
        // Locally initialized SQL resource with that argument (though SQL resources typically don't take PrintWriter,
        // scenario requires construction with such argument; using placeholder connection for demonstration)
        Connection conn = DriverManager.getConnection("jdbc:test", "user", "pass");
        // The argument association is conceptual here; actual SQL resources don't take writers as args
    }
}