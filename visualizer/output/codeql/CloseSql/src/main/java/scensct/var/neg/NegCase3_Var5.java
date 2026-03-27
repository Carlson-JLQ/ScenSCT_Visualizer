// A locally initialized SQL resource with a transitive parent closeable resource associated with a local variable should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class NegCase3_Var5 {
    public void test() throws Exception {
        try (Connection conn = DriverManager.getConnection("jdbc:test");
             PreparedStatement pstmt = conn.prepareStatement("SELECT 1")) {
            // PreparedStatement is also a Statement subtype, closed transitively
        }
    }
}