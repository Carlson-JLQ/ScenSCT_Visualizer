// A locally initialized SQL resource where there exists another locally initialized closeable parent resource should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class NegCase1_Var3 {
    public void test() throws Exception {
        // Variant 3: Introduce an intermediate variable for the parent
        Connection conn = DriverManager.getConnection("jdbc:test");
        try (Connection c = conn; Statement stmt = c.createStatement()) {
            // Parent passed via variable, still closeable
            stmt.executeQuery("SELECT * FROM dual");
        }
    }
}