// A locally initialized SQL resource where there exists another locally initialized closeable parent resource that does not flow into a variable and is not an argument of another locally initialized outer expression should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class NegCase9_Var1 {
    public void test() throws Exception {
        // Variant 1: Nested try-with-resources, parent still not assigned
        try (Connection conn = DriverManager.getConnection("jdbc:test")) {
            try (Statement stmt = conn.createStatement()) {
                // usage unchanged
            }
        }
    }
}