// A locally initialized SQL resource where there exists another locally initialized closeable parent resource should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class NegCase1_Var2 {
    public void test() throws Exception {
        // Variant 2: Nested try-with-resources, separating parent and child
        try (Connection conn = DriverManager.getConnection("jdbc:test")) {
            try (Statement stmt = conn.createStatement()) {
                // Child resource closed in inner block, parent in outer
                stmt.executeUpdate("DELETE FROM temp");
            }
        }
    }
}