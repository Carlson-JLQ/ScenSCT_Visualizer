// A locally initialized SQL resource nested within at least two other closeable resources should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class NegCase2_Var2 {
    public void test() throws Exception {
        // Introduce a temporary variable for the connection
        Connection conn = DriverManager.getConnection("jdbc:test");
        try (Connection c = conn; Statement stmt = c.createStatement()) {
            // Split the query execution
            String query = "SELECT 1";
            ResultSet rs = stmt.executeQuery(query);
            // Trivial if-block that doesn't break the nesting
            if (true) {
                int x = rs.getInt(1);
            }
        }
    }
}