// Scenario 4: A java.sql.Connection is locally initialized, used directly without storage, has no parent after exemptions, and is not closed.
package scensct.var.pos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PosCase4_Var5 {
    public void test() throws SQLException {
        // Variant 5: Introduce a try-finally that does NOT close the Connection.
        Connection conn = null;
        try {
            conn = DriverManager.getConnection("jdbc:example:db");
            conn.createStatement(); // [REPORTED LINE]
        } finally {
            // Intentionally no conn.close() — finally block does not close.
            System.out.println("done");
        }
    }
}