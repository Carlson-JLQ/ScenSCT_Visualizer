// A locally initialized SQL ResultSet obtained via a method call on a Statement variable, where Statement is a transitive parent closeable resource, should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class NegCase7_Var4 {
    public void test() throws Exception {
        try (Connection conn = DriverManager.getConnection("jdbc:test");
             Statement stmt = conn.createStatement()) {
            ResultSet rs = null;
            try {
                // Locally initialized inside try
                rs = stmt.executeQuery("SELECT 1");
            } catch (Exception e) {
                // Swallow exception; rs remains reachable only in this scope
                throw e;
            }
            // rs goes out of scope when stmt is closed
        }
    }
}