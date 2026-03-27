// A locally initialized SQL resource where there exists another locally initialized closeable parent resource that does not flow into a variable and is not an argument of another locally initialized outer expression should not be flagged as unclosed.
package scensct.core.neg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class NegCase9 {
    public void test() throws Exception {
        // Locally initialized closeable parent resource (Connection) not assigned to variable
        // and not used as argument to another outer expression
        // Directly used to create Statement
        try (Connection conn = DriverManager.getConnection("jdbc:test");
             Statement stmt = conn.createStatement()) {
            // Parent exists but doesn't flow into variable or outer expression
        }
    }
}