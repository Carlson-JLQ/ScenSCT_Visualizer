// A locally initialized SQL resource nested within at least two other closeable resources should not be flagged as unclosed.
package scensct.core.neg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class NegCase2 {
    public void test() throws Exception {
        // First closeable parent (Connection)
        try (Connection conn = DriverManager.getConnection("jdbc:test");
             // Second closeable parent (Statement)
             Statement stmt = conn.createStatement()) {
            // Locally initialized SQL resource (ResultSet) nested within two parents
            ResultSet rs = stmt.executeQuery("SELECT 1");
        }
    }
}