// A locally initialized SQL resource where there exists another locally initialized closeable parent resource should not be flagged as unclosed.
package scensct.var.neg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class NegCase1_Var4 {
    public void test() throws Exception {
        // Variant 4: Extract resource creation to a helper method, but keep in same try block
        try (Connection conn = createConnection(); Statement stmt = conn.createStatement()) {
            stmt.close(); // explicit close, but still auto-closed by try-with-resources
        }
    }

    private Connection createConnection() throws Exception {
        return DriverManager.getConnection("jdbc:test");
    }
}