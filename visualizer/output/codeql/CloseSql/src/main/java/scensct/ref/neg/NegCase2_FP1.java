// A locally initialized SQL resource nested within at least two other closeable resources should not be flagged as unclosed.
package scensct.ref.neg;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;

public class NegCase2_FP1 {
    public void test() throws Exception {
        // First closeable parent (Connection)
        Connection conn = DriverManager.getConnection("jdbc:test");
        // Second closeable parent (Statement)
        Statement stmt = conn.createStatement(); // [REPORTED LINE]
        // Locally initialized SQL resource (ResultSet) nested within two parents
        ResultSet rs = stmt.executeQuery("SELECT 1"); // [REPORTED LINE]
    }
}