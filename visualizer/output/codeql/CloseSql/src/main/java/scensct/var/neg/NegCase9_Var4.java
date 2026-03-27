// A locally initialized SQL resource where there exists another locally initialized closeable parent resource that does not flow into a variable and is not an argument of another locally initialized outer expression should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class NegCase9_Var4 {
    public void test() throws Exception {
        // Variant 4: Parent resource used in a for-loop that runs once,
        // still not flowing into a variable outside try-with-resources
        for (int i = 0; i < 1; i++) {
            try (Connection conn = DriverManager.getConnection("jdbc:test");
                 Statement stmt = conn.createStatement()) {
                // same
            }
        }
    }
}