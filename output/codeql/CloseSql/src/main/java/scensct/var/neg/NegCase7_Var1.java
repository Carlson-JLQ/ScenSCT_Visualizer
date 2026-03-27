// A locally initialized SQL ResultSet obtained via a method call on a Statement variable, where Statement is a transitive parent closeable resource, should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class NegCase7_Var1 {
    public void test() throws Exception {
        // Separate try-with-resources for Connection
        try (Connection conn = DriverManager.getConnection("jdbc:test")) {
            // Statement created from conn, still a closeable resource
            Statement stmt = conn.createStatement();
            try {
                // Locally initialized ResultSet via method call on Statement
                ResultSet rs = stmt.executeQuery("SELECT 1");
            } finally {
                stmt.close(); // explicit close ensures rs is closed transitively
            }
        }
    }
}