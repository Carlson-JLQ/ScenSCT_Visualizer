// A locally initialized SQL resource nested within at least two other closeable resources should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class NegCase2_Var4 {
    public void test() throws Exception {
        // Use try-catch-finally around the try-with-resources, but ensure nesting unchanged
        try {
            try (Connection conn = DriverManager.getConnection("jdbc:test");
                 Statement stmt = conn.createStatement()) {
                ResultSet rs = stmt.executeQuery("SELECT 1");
                // Simulate a possible exception that doesn't affect closure
                int val = Integer.parseInt("42");
            }
        } catch (NumberFormatException e) {
            // Ignore - resources already closed by try-with-resources
        }
    }
}