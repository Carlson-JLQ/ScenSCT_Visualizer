// A locally initialized SQL resource where there exists another locally initialized closeable parent resource that does not flow into a variable and is not an argument of another locally initialized outer expression should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class NegCase9_Var5 {
    public void test() throws Exception {
        // Variant 5: Parent resource created inside a dummy try-catch,
        // but still part of same try-with-resources clause
        try (Connection conn = DriverManager.getConnection("jdbc:test");
             Statement stmt = conn.createStatement()) {
            try {
                // do nothing
            } catch (RuntimeException e) {
                throw e;
            }
        }
    }
}