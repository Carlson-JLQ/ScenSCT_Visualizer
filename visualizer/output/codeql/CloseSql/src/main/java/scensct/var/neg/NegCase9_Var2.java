// A locally initialized SQL resource where there exists another locally initialized closeable parent resource that does not flow into a variable and is not an argument of another locally initialized outer expression should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class NegCase9_Var2 {
    public void test() throws Exception {
        // Variant 2: Parent resource created via a method returning Connection,
        // but still not stored in a variable before try-with-resources
        try (Connection conn = makeConnection();
             Statement stmt = conn.createStatement()) {
            // same scenario
        }
    }
    
    private Connection makeConnection() throws Exception {
        return DriverManager.getConnection("jdbc:test");
    }
}