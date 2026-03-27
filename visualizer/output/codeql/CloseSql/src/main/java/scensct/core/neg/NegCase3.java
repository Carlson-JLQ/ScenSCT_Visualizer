// A locally initialized SQL resource with a transitive parent closeable resource associated with a local variable should not be flagged as unclosed.
package scensct.core.neg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class NegCase3 {
    public void test() throws Exception {
        // Transitive parent closeable resource with local variable
        try (Connection conn = DriverManager.getConnection("jdbc:test");
             // Locally initialized SQL resource (Statement) with parent via closeableInit
             Statement stmt = conn.createStatement()) {
        }
    }
}