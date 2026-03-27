// A locally initialized SQL resource where there exists another locally initialized closeable parent resource should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class NegCase1_Var5 {
    public void test() throws Exception {
        // Variant 5: Loop structure that still guarantees closure
        for (int i = 0; i < 1; i++) {
            try (Connection conn = DriverManager.getConnection("jdbc:test");
                 Statement stmt = conn.createStatement()) {
                // Single iteration ensures execution
                break; // exit loop, resources closed
            }
        }
    }
}