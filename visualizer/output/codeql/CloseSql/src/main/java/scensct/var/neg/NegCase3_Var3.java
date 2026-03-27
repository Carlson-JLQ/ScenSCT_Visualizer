// A locally initialized SQL resource with a transitive parent closeable resource associated with a local variable should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class NegCase3_Var3 {
    public void test() throws Exception {
        try (Connection conn = DriverManager.getConnection("jdbc:test")) {
            // Statement created inside, still closed when conn closes
            try (Statement stmt = conn.createStatement()) {
                // empty
            }
        }
    }
}