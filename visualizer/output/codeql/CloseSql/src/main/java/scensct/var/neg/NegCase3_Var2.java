// A locally initialized SQL resource with a transitive parent closeable resource associated with a local variable should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class NegCase3_Var2 {
    public void test() throws Exception {
        // Keep parent-child relationship, just rename
        try (Connection parent = DriverManager.getConnection("jdbc:test");
             Statement child = parent.createStatement()) {
            // No-op
        }
    }
}