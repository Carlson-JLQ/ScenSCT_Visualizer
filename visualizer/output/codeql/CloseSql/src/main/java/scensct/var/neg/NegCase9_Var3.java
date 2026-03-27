// A locally initialized SQL resource where there exists another locally initialized closeable parent resource that does not flow into a variable and is not an argument of another locally initialized outer expression should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class NegCase9_Var3 {
    public void test() throws Exception {
        // Variant 3: Parent resource wrapped in a conditional that always executes,
        // but still not assigned to a variable outside try-with-resources
        boolean flag = true;
        if (flag) {
            try (Connection conn = DriverManager.getConnection("jdbc:test");
                 Statement stmt = conn.createStatement()) {
                // same
            }
        }
    }
}